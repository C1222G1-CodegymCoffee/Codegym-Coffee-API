package com.example.codegym_coffee.repository.menu;

import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuRepository extends JpaRepository<Product , Integer> {
    @Query(value = "select * from product join product_type pt on pt.id_type = product.id_type where name_type = ?1" , nativeQuery = true)
    List<Product> getProductByType(String type) ;

    @Query(value = "select * from product join product_type pt on pt.id_type = product.id_type where name_product like CONCAT('%',?1, '%')" , nativeQuery = true)
    List<Product> getProductByName(String nameProduct);
}

