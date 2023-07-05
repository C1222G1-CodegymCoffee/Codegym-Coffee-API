package com.example.codegym_coffee.repository.menu;

import com.example.codegym_coffee.model.TableCoffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITableCoffeeRepository extends JpaRepository<TableCoffee,Integer> {
    @Query(value = "select * from table_coffee where name_table = ?1",nativeQuery = true)
    TableCoffee findByNameTable(int tableOfBill);

    @Query(value = "select * from table_coffee where status = 0 LIMIT 1",nativeQuery = true)
    TableCoffee getAvailableTable();
}
