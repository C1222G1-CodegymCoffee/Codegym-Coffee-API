package com.example.codegym_coffee.dto.accountDTO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AuthRequest {
    @NotNull(message = "Trường này không được để trống")
    @Length(min = 5, max = 10, message = "tên tài khoản nằm trong khoảng 5 đến 10 ký tự" )
    private String nameAccount;

    @NotNull(message = "Trường này không được để trống")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,8}$", message = "mật khẩu nằm trong khoảng 6 đến 8 ký tự")
    private String password;

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
