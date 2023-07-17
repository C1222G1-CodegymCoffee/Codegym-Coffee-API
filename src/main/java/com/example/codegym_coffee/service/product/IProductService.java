package com.example.codegym_coffee.service.product;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import org.springframework.stereotype.Service;


@Service
public interface IProductService {

    void updateProduct(String nameProduct, String ingredient,
                       Double price, String image, Integer idType, Integer idProduct);

    
    void createProduct(ProductDTO productDTO);

   
    Product findById(int id);

}
