package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "name_product",columnDefinition = "Varchar(40)")
    private String nameProduct;

    @Column(name = "ingredient", columnDefinition = "MEDIUMTEXT")
    private String ingredient;

    @Column(name = "price", columnDefinition = "DOUBLE")
    private Double price;

    @Column(name = "image", columnDefinition = "MEDIUMTEXT")
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    private ProductType productType;

    public Product() {
    }

    public Product(Integer idProduct, String nameProduct, String ingredient, Double price, String image, ProductType productType) {
        this.idProduct = idProduct;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
