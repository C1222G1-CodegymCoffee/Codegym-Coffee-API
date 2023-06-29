package com.example.codegym_coffee.dto.product;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ProductTypeDTO {
    private Integer idType;
    @NotBlank(message = "Nhóm món không được để trống")
    private String nameType;

    public ProductTypeDTO() {
    }

    public ProductTypeDTO(Integer idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
