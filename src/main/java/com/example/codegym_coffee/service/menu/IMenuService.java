package com.example.codegym_coffee.service.menu;

import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMenuService {
    List<Product> getAllProduct();
    List<ProductType> getAllTypeProduct();
}
