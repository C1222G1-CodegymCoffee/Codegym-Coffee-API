package com.example.codegym_coffee.dto.product;

import com.example.codegym_coffee.model.ProductType;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


public class ProductDTO implements Validator {
    private Integer idProduct;
    private String codeProduct;
    @NotBlank(message = "Tên món không được để trống")
    @Length(max = 40,message = "Tên món không dài quá 40 từ")
    private String nameProduct;
    @NotBlank(message = "Thành phần không được để trống")
    private String ingredient;
    @NotBlank(message = "Giá không được để trống")
    private double price;
    @NotBlank(message = "Ảnh không được để trống")
    private String image;
    @NotBlank(message = "Nhóm món không được để trống")
    private ProductType productType;

    public ProductDTO(Integer idProduct, String codeProduct, String nameProduct, String ingredient, double price, String image, ProductType productType) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.ingredient = ingredient;
        this.price = price;
        this.image = image;
        this.productType = productType;
    }

    public ProductDTO() {

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
