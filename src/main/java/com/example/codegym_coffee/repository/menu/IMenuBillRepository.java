package com.example.codegym_coffee.repository.menu;

import com.example.codegym_coffee.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuBillRepository extends JpaRepository<Bill,Integer> {
    @Query(value = "SELECT * FROM bill where id_table = ?1 ORDER BY id_bill DESC LIMIT 1",nativeQuery = true)
    Bill getBillByTable(Integer idTable);
}
