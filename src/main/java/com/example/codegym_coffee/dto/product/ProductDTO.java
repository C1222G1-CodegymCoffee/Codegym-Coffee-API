package com.example.codegym_coffee.dto.product;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class ProductDTO implements Validator {
    private Integer idProduct;
    @NotBlank(message = "Tên món không được để trống")
    @Length(max = 20, message = "Tên món không dài quá 20 từ")
    @Length(min = 5, message = "Tên món phải nhiều hơn 5 từ")
    @Pattern(regexp = "^[^0-9]*$", message = "Tên món không được chứa số ")
    private String nameProduct;
    @NotBlank(message = "Thành phần không được để trống")
    @Length(max = 30, message = "Thành phần không dài quá 30 từ")
    @Length(min = 5, message = "Thành phần phải nhiều hơn 5 từ")
    @Pattern(regexp = "^[^0-9]*$", message = "Thành phần không được chứa số ")
    private String ingredient;
    private Double price;
    private String image;
    private ProductTypeDTO productTypeDTO;

    public ProductDTO() {
    }

    public ProductDTO(Integer idProduct, String nameProduct, String ingredient, Double price, String image, ProductTypeDTO productTypeDTO) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.ingredient = ingredient;
        this.price = price;
        this.image = image;
        this.productTypeDTO = productTypeDTO;
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

    public ProductTypeDTO getProductTypeDTO() {
        return productTypeDTO;
    }

    public void setProductTypeDTO(ProductTypeDTO productTypeDTO) {
        this.productTypeDTO = productTypeDTO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }


}
