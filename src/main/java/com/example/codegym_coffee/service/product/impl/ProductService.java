package com.example.codegym_coffee.service.product.impl;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.repository.product.IProductRepository;
import com.example.codegym_coffee.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public void updateProduct(String codeProduct, String ingredient, String nameProduct,
                              Double price, String image, Integer idType, Integer idProduct) {
        productRepository.updateProduct(codeProduct, ingredient, nameProduct, price, image, idType, idProduct);
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepository.saveProduct(productDTO.getCodeProduct(), productDTO.getIngredient(), productDTO.getNameProduct(),
                productDTO.getPrice(), productDTO.getImage(), productDTO.getProductTypeDTO().getIdType());
    }


    @Override
    public Product findById(int id) {
        return productRepository.findByIdProduct(id);
    }
}
