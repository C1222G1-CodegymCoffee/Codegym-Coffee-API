package com.example.codegym_coffee.dto.menu;

public class ProductMenuDto {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int quantityOfProduct;
//    private int tableOfBill;

    public ProductMenuDto() {
    }

//    public ProductMenuDto(int idProduct, String nameProduct, double price, int quantityOfProduct, int tableOfBill) {
//        this.idProduct = idProduct;
//        this.nameProduct = nameProduct;
//        this.price = price;
//        this.quantityOfProduct = quantityOfProduct;
//        this.tableOfBill = tableOfBill;
//    }


    public ProductMenuDto(int idProduct, String nameProduct, double price, int quantityOfProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantityOfProduct = quantityOfProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setQuantityOfProduct(int quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }

//    public int getTableOfBill() {
//        return tableOfBill;
//    }
//
//    public void setTableOfBill(int tableOfBill) {
//        this.tableOfBill = tableOfBill;
//    }
}
