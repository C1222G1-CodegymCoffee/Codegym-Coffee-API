package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "code_product",columnDefinition = "Varchar(40)")
    private String codeProduct;

    @Column(name = "name_product",columnDefinition = "Varchar(40)")
    private String nameProduct;

    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String ingredient;

    @Column(name = "price",columnDefinition = "DOUBLE")
    private double price;

    @Column(name = "image",columnDefinition = "MEDIUMTEXT")
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    private ProductType productType;

    public Product() {
    }

    public Product(Integer idProduct, String codeProduct, String nameProduct,
                   String ingredient, double price, String image, ProductType productType) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.ingredient = ingredient;
        this.price = price;
        this.image = image;
        this.productType = productType;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
