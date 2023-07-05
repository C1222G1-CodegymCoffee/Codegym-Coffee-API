package com.example.codegym_coffee.service.menu.impl;

import com.example.codegym_coffee.model.*;
import com.example.codegym_coffee.repository.menu.*;
import com.example.codegym_coffee.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {
    @Autowired
    private IMenuBillRepository menuBillRepository;
    @Autowired
    private ITableCoffeeRepository tableCoffeeRepository;
    @Autowired
    private IMenuRepository menuRepository;

    @Autowired
    private ITypeMenuRepository typeMenuRepository ;
    @Autowired
    private IMenuBD menuBD;

    @Override
    public List<Product> getAllProduct() {
        return menuRepository.findAll();
    }

    @Override
    public List<ProductType> getAllTypeProduct() {
        return typeMenuRepository.findAll();
    }

    @Override
    public List<Product> getProductByTypeProduct(String type) {
        return menuRepository.getProductByType(type);
    }

    @Override
    public void addBillDetail(BillDetail billDetail) {
        menuBD.save(billDetail);
    }

    @Override
    public TableCoffee getTableCoffee(int tableOfBill) {
        return tableCoffeeRepository.findByNameTable(tableOfBill);
    }

    @Override
    public TableCoffee getAvailableTableCoffee() {
        return tableCoffeeRepository.getAvailableTable();
    }

    @Override
    public void createBill(Bill bill) {
        menuBillRepository.save(bill);
    }

    @Override
    public Bill getBillByTable(Integer idTable) {
        return menuBillRepository.getBillByTable(idTable);
    }

    @Override
    public List<Product> getProductByNameProduct(String nameProduct) {
        return menuRepository.getProductByName(nameProduct);
    }

    @Override
    public void updateTable(TableCoffee tableCoffee) {
        tableCoffeeRepository.save(tableCoffee);
    }


}
