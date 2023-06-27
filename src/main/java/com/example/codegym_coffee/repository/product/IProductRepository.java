package com.example.codegym_coffee.repository.product;

import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    /**
     * Create by: NghiaLD,
     * Date create : 27/06/2023
     * Function : Find product by id
     *
     * @param id
     */
    @Transactional
    @Query(value = "select * from product where id_product = :id_product", nativeQuery = true)
    Product findByIdProduct(@Param("id_product") Integer id);

    boolean existsProductByCodeProduct(String codeProduct);

    /**
     * Create by: NghiaLD,
     * Date create : 27/06/2023
     * Function : Add new product to database
     *
     * @param ingredient
     * @param name
     * @param price
     * @param image
     * @param productType
     */
    @Modifying
    @Transactional
    @Query(value = "insert into product(ingredient , name_product , price_of_product , image , productType) values (:id_product,:ingredient,:address,:name_product ,:price_of_product , :image , :email , :productType )", nativeQuery = true)
    void saveProduct(
            @Param("ingredient") String ingredient,
            @Param("name_product") String name,
            @Param("price_of_product") Double price,
            @Param("image") String image,
            @Param("productType") ProductType productType
    );

    /**
     * Create by: NghiaLD,
     * Date create : 27/06/2023
     * Function : Update product to database
     *
     * @param ingredient
     * @param name
     * @param price
     * @param image
     * @param productType
     */
    @Modifying
    @Transactional
    @Query(value = "update product set ingredient = :ingredient, name_product = :name_product , price_of_product = :price_of_product , image = :image ,productType = :productType WHERE id = :id", nativeQuery = true)
    void updateProduct(
            @Param("ingredient") String ingredient,
            @Param("name_product") String name,
            @Param("price_of_product") Double price,
            @Param("image") String image,
            @Param("productType") ProductType productType);
}
