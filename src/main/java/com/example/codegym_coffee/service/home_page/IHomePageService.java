package com.example.codegym_coffee.service.home_page;

import com.example.codegym_coffee.model.Product;

import java.util.List;

public interface IHomePageService {
    List<Product> findTopProduct();

    List<Product> findNewProduct();
}
