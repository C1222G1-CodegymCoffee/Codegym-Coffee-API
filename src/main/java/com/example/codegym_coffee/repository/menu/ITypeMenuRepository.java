package com.example.codegym_coffee.repository.menu;

import com.example.codegym_coffee.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeMenuRepository extends JpaRepository<ProductType , Integer> {
}
