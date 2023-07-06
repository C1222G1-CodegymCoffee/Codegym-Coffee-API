package com.example.codegym_coffee.dto.billDto;

import com.example.codegym_coffee.model.BillDetail;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.model.Feedback;
import com.example.codegym_coffee.model.TableCoffee;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class BillDto {

    private Integer idBill;


    private String codeBill;


    private LocalDate dayOfBill;

    private Integer paymentStatus;

    private Employee employee;

    private TableCoffee tableCoffee;


    private Feedback feedback;


    private List<BillDetail> billDetails;
    private Double totalPrice;

    public BillDto() {
    }

    public BillDto(Integer idBill, String codeBill, LocalDate dayOfBill, Integer paymentStatus, Employee employee, TableCoffee tableCoffee, Feedback feedback, List<BillDetail> billDetails, Double totalPrice) {
        this.idBill = idBill;
        this.codeBill = codeBill;
        this.dayOfBill = dayOfBill;
        this.paymentStatus = paymentStatus;
        this.employee = employee;
        this.tableCoffee = tableCoffee;
        this.feedback = feedback;
        this.billDetails = billDetails;
        this.totalPrice = totalPrice;
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

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TableCoffee getTableCoffee() {
        return tableCoffee;
    }

    public void setTableCoffee(TableCoffee tableCoffee) {
        this.tableCoffee = tableCoffee;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
