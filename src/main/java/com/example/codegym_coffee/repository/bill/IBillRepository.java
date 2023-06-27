package com.example.codegym_coffee.repository.bill;

import com.example.codegym_coffee.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "select id_bill, code_bill, day_of_bill, employee_id, id_feedback, id_table from bill", nativeQuery = true)
    Page<Bill> showListBill(Pageable pageable);
}
