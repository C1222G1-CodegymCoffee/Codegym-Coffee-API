package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "date")
    private String dayOfBill;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "feedback_id", referencedColumnName = "id")
    private Feedback feedback;
    @ManyToOne
    @JoinColumn(name = "table_coffee_id", referencedColumnName = "id")
    private TableCoffee tableCoffee;

    public Bill() {
    }

    public Bill(int id, String dayOfBill, Employee employee, Feedback feedback, TableCoffee tableCoffee) {
        this.id = id;
        this.dayOfBill = dayOfBill;
        this.employee = employee;
        this.feedback = feedback;
        this.tableCoffee = tableCoffee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayOfBill() {
        return dayOfBill;
    }

    public void setDayOfBill(String dayOfBill) {
        this.dayOfBill = dayOfBill;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public TableCoffee getTableCoffee() {
        return tableCoffee;
    }

    public void setTableCoffee(TableCoffee tableCoffee) {
        this.tableCoffee = tableCoffee;
    }
}
