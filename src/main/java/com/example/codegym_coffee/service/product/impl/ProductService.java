package com.example.codegym_coffee.service.product.impl;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import com.example.codegym_coffee.repository.product.IProductRepository;
import com.example.codegym_coffee.repository.product.IProductTypeRepository;
import com.example.codegym_coffee.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public void updateProduct(String nameProduct, String ingredient,
                              Double price, String image, Integer idType, Integer idProduct) {
        productRepository.updateProduct(nameProduct, ingredient, price, image, idType, idProduct);
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepository.saveProduct(productDTO.getNameProduct(), productDTO.getIngredient(),
                productDTO.getPrice(), productDTO.getImage(), productDTO.getProductTypeDTO().getIdType());
    }


    @Override
    public Product findById(int id) {
        return productRepository.findByIdProduct(id);
    }


}
