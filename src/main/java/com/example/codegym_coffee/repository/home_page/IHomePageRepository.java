package com.example.codegym_coffee.repository.home_page;

import com.example.codegym_coffee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHomePageRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT p.*,SUM(bd.quantity_product) AS totalQuantityProduct FROM bill_detail bd JOIN product p ON p.id_product = bd.id_product GROUP BY p.id_product, p.name_product ORDER BY totalQuantityProduct DESC LIMIT 6", nativeQuery = true)
    List<Product> findTopProduct();

    @Query(value = "SELECT * FROM product ORDER BY id_product DESC LIMIT 6", nativeQuery = true)
    List<Product> findNewProduct();
}
