package com.example.codegym_coffee.service.menu.impl;

import com.example.codegym_coffee.model.BillDetail;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import com.example.codegym_coffee.repository.menu.IMenuBD;
import com.example.codegym_coffee.repository.menu.IMenuRepository;
import com.example.codegym_coffee.repository.menu.ITypeMenuRepository;
import com.example.codegym_coffee.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {
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

}
