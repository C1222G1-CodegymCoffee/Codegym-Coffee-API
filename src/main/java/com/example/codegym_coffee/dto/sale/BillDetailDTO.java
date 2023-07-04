package com.example.codegym_coffee.dto.sale;

public interface BillDetailDTO {
    Integer getIdBillDetail();
    String getNameProduct();
    Integer getQuantityOfProduct();
    Double getPrice();
    String getNameTable();
    Double getTotalPrice();
    Double getTotalAmount();
}
