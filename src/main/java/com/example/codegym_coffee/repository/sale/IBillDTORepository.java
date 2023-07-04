package com.example.codegym_coffee.repository.sale;

import com.example.codegym_coffee.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillDTORepository extends JpaRepository<Bill,Integer> {
    Bill findByIdBill(int id);
}
