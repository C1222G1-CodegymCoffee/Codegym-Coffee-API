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
   
    @Query(value = "select * from product where id_product = :id_product", nativeQuery = true)
    Product findByIdProduct(@Param("id_product") Integer id);

   

    @Modifying
    @Query(value = "insert into product(name_product ,ingredient, price , image , id_type) values ( :name_product, :ingredient ,:price , :image  , :id_type )", nativeQuery = true)
    void saveProduct(
            @Param("name_product") String nameProduct,
            @Param("ingredient") String ingredient,
            @Param("price") Double price,
            @Param("image") String image,
            @Param("id_type") Integer idType
    );

    


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
