package com.example.codegym_coffee.repository.menu;

import com.example.codegym_coffee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuRepository extends JpaRepository<Product , Integer> {
}

