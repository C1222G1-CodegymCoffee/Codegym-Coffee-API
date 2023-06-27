package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
@Table(name = "bill_detail")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill_detail")
    private Integer idBillDetail;
    @Column(name = "quantity_product")
    private int quantityOfProduct;

    @Column(name ="price_of_product",columnDefinition = "DOUBLE")
    private double priceOfProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "id_product",referencedColumnName = "id_product", nullable = false)
    private Product product;

    public BillDetail() {
    }

    public BillDetail(Integer idBillDetail, int quantityOfProduct, double priceOfProduct, Product product) {
        this.idBillDetail = idBillDetail;
        this.quantityOfProduct = quantityOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.product = product;
    }

    public Integer getIdBillDetail() {
        return idBillDetail;
    }

    public void setIdBillDetail(Integer idBillDetail) {
        this.idBillDetail = idBillDetail;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
