package com.example.codegym_coffee.controller.login;

import com.example.codegym_coffee.config.MyUserPrincipal;
import com.example.codegym_coffee.dto.accountDTO.AuthRequest;
import com.example.codegym_coffee.dto.accountDTO.AuthResponse;
import com.example.codegym_coffee.dto.accountDTO.EmailConfirm;
import com.example.codegym_coffee.dto.accountDTO.GenericRequest;
import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.service.account.IAccountService;
import com.example.codegym_coffee.utils.JwtTokenUtil;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtUtil;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping(value = "/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        String errorMessages = "Tài khoản hoặc mật khẩu của bạn không đúng";
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getNameAccount(), request.getPassword())
            );

            MyUserPrincipal account = (MyUserPrincipal) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(account);
            AuthResponse response = new AuthResponse(account.getUsername(), account.getAuthorities(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/forgot_password")
    public ResponseEntity<?> forgotPassword(@RequestBody EmailConfirm emailConfirm) throws MessagingException, UnsupportedEncodingException {
        String message = "email bạn nhập không tồn tại";
        String token = RandomString.make(30);
        try {
            accountService.updateResetPasswordToken(token, emailConfirm.getEmailConfirm());
            String resetPasswordLink = emailConfirm.getLocation() + "/reset_password";
            sendEmail(emailConfirm.getEmailConfirm(), resetPasswordLink);
            return new ResponseEntity<>(new EmailConfirm(emailConfirm.getEmailConfirm(), token), HttpStatus.OK);
        } catch (MessagingException | UnsupportedEncodingException e){
            e.getStackTrace();
        }
        return new ResponseEntity<>( message, HttpStatus.BAD_REQUEST);
    }

    public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("codegymcoffee@gmail.com", "Hỗ trợ dịch vụ");
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

    @PostMapping("/reset_password")
    public ResponseEntity<GenericRequest> resetPassword(@RequestBody @Valid GenericRequest genericRequest) {

        Account account = accountService.getByResetPasswordToken(genericRequest.getToken());

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            accountService.updatePassword(account, genericRequest.getPassword());
            return new ResponseEntity<>(HttpStatus.OK);

        }
    }

    @GetMapping("/403")
    public ResponseEntity<?> daniedPage() {
        String message = "Bạn không có quyền truy cập trang này";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}