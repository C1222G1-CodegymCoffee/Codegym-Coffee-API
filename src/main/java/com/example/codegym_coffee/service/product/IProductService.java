package com.example.codegym_coffee.service.product;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
//    /**
//     * Created by: NghiaLD
//     * Date created: 27/06/2023
//     * function: Update product
//     *
//     * @param productDTO
//     * @param id
//     */
//    void updateProduct(ProductDTO productDTO, Integer id);

    /**
     * Created by: NghiaLD
     * Date created: 27/06/2023
     * Function : Edit information of product
     *
     * @param ingredient
     * @param nameProduct
     * @param price
     * @param image
     * @param productType
     */

    void updateProduct(String ingredient, String nameProduct, Double price, String image, ProductType productType);

    /**
     * Create by: NghiaLD,
     * Date create : 27/06/2023
     * Function : Create new product
     *
     * @param ingredient
     * @param name
     * @param price
     * @param image
     * @param productType
     */
    void createProduct(String ingredient, String name, Double price, String image, ProductType productType);

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
