package com.example.codegym_coffee.service.product.impl;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import com.example.codegym_coffee.repository.product.IProductRepository;
import com.example.codegym_coffee.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public void updateProduct(String ingredient, String nameProduct, Double price, String image, ProductType productType) {
        productRepository.updateProduct(ingredient, nameProduct, price, image, productType);
    }

    @Override
    public void createProduct(String ingredient, String name, Double price, String image, ProductType productType) {
        productRepository.saveProduct(ingredient, name, price, image, productType);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findByIdProduct(id);
    }
}
