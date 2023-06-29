package com.example.codegym_coffee.controller.login;

import com.example.codegym_coffee.dto.accountDTO.AuthRequest;
import com.example.codegym_coffee.dto.accountDTO.AuthResponse;
import com.example.codegym_coffee.dto.accountDTO.GenericRequest;
import com.example.codegym_coffee.dto.accountDTO.Utility;
import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.service.login.IAccountService;
import com.example.codegym_coffee.utils.JwtTokenUtil;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtUtil;

    @Autowired
    private IAccountService accountService;

    @PostMapping(value = "/api/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getNameAccount(), request.getPassword())
            );

            Account account = (Account) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(account);
            AuthResponse response = new AuthResponse(account.getNameAccount(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logout";
    }

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/forgot_password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email,HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {

        String token = RandomString.make(30);

        try {
            accountService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (MessagingException | UnsupportedEncodingException e){
             e.getStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("hoang11761311@gmail.com", "Hỗ trợ dịch vụ");
        helper.setTo(recipientEmail);

        String subject = "Lấy mật khẩu";

        String content = "<p>Chào bạn đến với Codegym Coffee,</p>"
                + "<p>Bạn có yêu cầu đặt lại mật khẩu của bạn.</p>"
                + "<p>Nhấn vào đường link để thay đổi mật khẩu:</p>"
                + "<p><a href=\"" + link + "\">Thay đổi mật khẩu</a></p>"
                + "<br>"
                + "<p>Bỏ qua nếu như bạn nhớ lại mật khẩu. </p> ";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }


    @GetMapping("/reset_password")
    public ResponseEntity<?> showResetPasswordForm(@Param(value = "token") String token, Model model) {
        Account account = accountService.getByResetPasswordToken(token);

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/reset_password")
    public ResponseEntity<?> resetPassword(@RequestBody @Valid GenericRequest genericRequest) {
//        String token = request.getParameter("token");
//        String password = request.getParameter("password");

        Account account = accountService.getByResetPasswordToken(genericRequest.getToken());

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            accountService.updatePassword(account, genericRequest.getPassword());
            return new ResponseEntity<>(HttpStatus.OK);

        }
    }
}
