package com.example.codegym_coffee.repository.product;

import com.example.codegym_coffee.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
    @Query(value = "select * from product_type", nativeQuery = true)
    List<ProductType> findAllProductType();
}
