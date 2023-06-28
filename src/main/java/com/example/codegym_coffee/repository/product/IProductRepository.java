package com.example.codegym_coffee.repository.product;

import com.example.codegym_coffee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    boolean existsProductByCodeProduct(String codeProduct);

    /**
     * Create by: NghiaLD,
     * Date create : 27/06/2023
     * Function : Add new product to database
     * @param codeProduct
     * @param ingredient
     * @param nameProduct
     * @param price
     * @param image
     * @Param id_type
     */

    @Modifying
    @Query(value = "insert into product( code_product, ingredient , name_product , price , image , id_type) values (:code_product, :ingredient,:name_product ,:price , :image  , :id_type )", nativeQuery = true)
    void saveProduct(
            @Param("code_product") String codeProduct,
            @Param("ingredient") String ingredient,
            @Param("name_product") String nameProduct,
            @Param("price") Double price,
            @Param("image") String image,
            @Param("id_type") Integer idType
    );

//    /**
//     * Create by: NghiaLD,
//     * Date create : 27/06/2023
//     * Function : Update product to database
//     *
//     * @param codeProduct
//     * @param ingredient
//     * @param nameProduct
//     * @param price
//     * @param image
//     * @param idType
//     * @param idProduct
//     */


    @Modifying
    @Query(value = "update product set code_product = :codeProduct, ingredient = :ingredient, name_product = :nameProduct , price = :price , image = :image ,id_type = :id_type WHERE id_product = :id_product", nativeQuery = true)
    void updateProduct(
            @Param("codeProduct") String codeProduct,
            @Param("ingredient") String ingredient,
            @Param("nameProduct") String nameProduct,
            @Param("price") Double price,
            @Param("image") String image,
            @Param("id_type") Integer idType,
            @Param("id_product") Integer idProduct);
}
