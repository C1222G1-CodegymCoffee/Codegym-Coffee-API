package com.example.codegym_coffee.repository.menu;

import com.example.codegym_coffee.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuBD extends JpaRepository<BillDetail,Integer> {
}
