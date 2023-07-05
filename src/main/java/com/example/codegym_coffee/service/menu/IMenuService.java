package com.example.codegym_coffee.service.menu;

import com.example.codegym_coffee.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMenuService {
    List<Product> getAllProduct();
    List<ProductType> getAllTypeProduct();
    List<Product> getProductByTypeProduct(String type);

    void addBillDetail(BillDetail billDetail);


    TableCoffee getTableCoffee(int tableOfBill);

    void createBill(Bill bill);

    Bill getBillByTable(Integer idTable);

    List<Product> getProductByNameProduct(String nameProduct);

    void updateTable(TableCoffee tableCoffee);
}
