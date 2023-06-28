package com.example.codegym_coffee.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill")
    private Integer idBill;
    @Column(name = "code_bill", columnDefinition = "Varchar(40)")
    private String codeBill;

    @Column(name = "day_of_bill",columnDefinition = "date")
    private LocalDate dayOfBill;

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

    public Bill(Integer idBill, String codeBill, LocalDate dayOfBill,
                Employee employee, TableCoffee tableCoffee, Feedback feedback) {
        this.idBill = idBill;
        this.codeBill = codeBill;
        this.dayOfBill = dayOfBill;
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
