package com.example.codegym_coffee.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill")
    private Integer idBill;

    @Column(name = "day_of_bill",columnDefinition = "date")
    private LocalDate dayOfBill;
    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_table", referencedColumnName = "id_table")
    private TableCoffee tableCoffee;


    @OneToOne(optional = true)
    @JoinColumn(name = "id_feedback", referencedColumnName = "id_feedback")
    private Feedback feedback;

    public Bill() {
    }

    public Bill(Integer idBill, LocalDate dayOfBill, int status, Employee employee, TableCoffee tableCoffee, Feedback feedback) {
        this.idBill = idBill;
        this.dayOfBill = dayOfBill;
        this.status = status;
        this.employee = employee;
        this.tableCoffee = tableCoffee;
        this.feedback = feedback;
    }

    public Bill(LocalDate dayOfBill, int status, Employee employee,  Feedback feedback,TableCoffee tableCoffee) {
        this.dayOfBill = dayOfBill;
        this.status = status;
        this.employee = employee;
        this.tableCoffee = tableCoffee;
        this.feedback = feedback;
    }

    public Integer getIdBill() {
        return idBill;
    }

    public void setIdBill(Integer idBill) {
        this.idBill = idBill;
    }

    public LocalDate getDayOfBill() {
        return dayOfBill;
    }

    public void setDayOfBill(LocalDate dayOfBill) {
        this.dayOfBill = dayOfBill;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}
