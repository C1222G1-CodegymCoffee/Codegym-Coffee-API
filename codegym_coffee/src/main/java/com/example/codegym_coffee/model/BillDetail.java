package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantityOfProduct;
    private double priceOfProduct;
    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public BillDetail() {
    }

    public BillDetail(int id, int quantityOfProduct, double priceOfProduct, Bill bill, Product product) {
        this.id = id;
        this.quantityOfProduct = quantityOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.bill = bill;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setQuantityOfProduct(int quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
