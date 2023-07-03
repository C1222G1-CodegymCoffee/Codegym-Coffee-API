package com.example.codegym_coffee.repository.product;

import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    /**
     * Create by: NghiaLD,
     * Date create : 27/06/2023
     * Function : Find product by id
     *
     * @param id
     */
    @Query(value = "select * from product where id_product = :id_product", nativeQuery = true)
    Product findByIdProduct(@Param("id_product") Integer id);

    /**
     * Create by: NghiaLD,
     * Date create : 27/06/2023
     * Function : Add new product to database
     * @param nameProduct
     * @param ingredient
     * @param price
     * @param image
     * @param idType
     */

    @Modifying
    @Query(value = "insert into product(name_product ,ingredient, price , image , id_type) values ( :name_product, :ingredient ,:price , :image  , :id_type )", nativeQuery = true)
    void saveProduct(
            @Param("name_product") String nameProduct,
            @Param("ingredient") String ingredient,
            @Param("price") Double price,
            @Param("image") String image,
            @Param("id_type") Integer idType
    );

    /**
     * Create by: NghiaLD,
     * Date create : 27/06/2023
     * Function : Update product to database
     *
     *@param nameProduct
     * @param ingredient
     * @param price
     * @param image
     * @param idType
     * @param idProduct
     */


    @Modifying
    @Query(value = "update product set  name_product = :nameProduct, ingredient = :ingredient, price = :price , image = :image ,id_type = :id_type WHERE id_product = :id_product", nativeQuery = true)
    void updateProduct(
            @Param("nameProduct") String nameProduct,
            @Param("ingredient") String ingredient,
            @Param("price") Double price,
            @Param("image") String image,
            @Param("id_type") Integer idType,
            @Param("id_product") Integer idProduct);
}
