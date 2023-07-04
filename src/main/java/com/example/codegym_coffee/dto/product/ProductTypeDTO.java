package com.example.codegym_coffee.dto.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ProductTypeDTO {
    private int idType;
    @NotBlank(message = "Nhóm món không được để trống")
    private String nameType;

    public ProductTypeDTO() {
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
