package com.example.codegym_coffee.dto.bill;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import java.time.LocalDate;

public class BillDTO implements Validator {
    private Integer idBill;

    private String codeBill;
    private LocalDate dayOfBill;

    public BillDTO() {
    }

    public Integer getIdBill() {
        return idBill;
    }

    public void setIdBill(Integer idBill) {
        this.idBill = idBill;
    }

    public String getCodeBill() {
        return codeBill;
    }

    public void setCodeBill(String codeBill) {
        this.codeBill = codeBill;
    }

    public LocalDate getDayOfBill() {
        return dayOfBill;
    }

    public void setDayOfBill(LocalDate dayOfBill) {
        this.dayOfBill = dayOfBill;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
