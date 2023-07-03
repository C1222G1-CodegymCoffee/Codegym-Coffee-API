package com.example.codegym_coffee.service.product;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import org.springframework.stereotype.Service;


@Service
public interface IProductService {

    void updateProduct(String nameProduct, String ingredient,
                       Double price, String image, Integer idType, Integer idProduct);

    /**
     * Create by: NghiaLD,
     * Date create : 27/06/2023
     * Function : Create new product
     */
    void createProduct(ProductDTO productDTO);

    /**
     * Created by: NghiaLD
     * Date created: 27/06/2023
     * function: Find product by id
     *
     * @param id
     * @return
     */
    Product findById(int id);

}
