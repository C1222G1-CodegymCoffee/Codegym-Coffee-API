package com.example.codegym_coffee.service.product.impl;

import com.example.codegym_coffee.model.ProductType;
import com.example.codegym_coffee.repository.product.IProductTypeRepository;
import com.example.codegym_coffee.service.product.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAllProductType() {
        return productTypeRepository.findAllProductType();
    }
}
