package com.example.codegym_coffee.controller.account;

import com.example.codegym_coffee.dto.account.ChangePasswordForm;
import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use the changePassword method to change password.If not unsuccessful return HttpStatus.BAD_REQUEST.
     If successful return message and return HttpStatus.OK

     * @param changePasswordForm
     * @param bindingResult
     * @return
     */
    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@Validated @RequestBody ChangePasswordForm changePasswordForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        Account account = iAccountService.findByNameAccount(changePasswordForm.getNameAccount());
        if(account==null){
            return new ResponseEntity<>("Tài khoản không tồn tại", HttpStatus.BAD_REQUEST);
        }
        if (Boolean.FALSE.equals(iAccountService.checkIfValidOldPassword(account, changePasswordForm.getOldPassword()))) {
            return new ResponseEntity<>("Mật khẩu hiện tại không đúng", HttpStatus.BAD_REQUEST);
        }
        if (changePasswordForm.getNewPassword().equals(changePasswordForm.getOldPassword())) {
            return new ResponseEntity<>("Mật khẩu mới không được trùng với mật khẩu cũ", HttpStatus.BAD_REQUEST);
        }
        if (!changePasswordForm.getNewPassword().equals(changePasswordForm.getConfirmPassword())) {
            return new ResponseEntity<>("Mật khẩu xác nhận không trùng khớp", HttpStatus.BAD_REQUEST);
        }
        iAccountService.changePassword(account, changePasswordForm.getNewPassword());
        return ResponseEntity.ok("Đổi mật khẩu thành công!");
    }
}
