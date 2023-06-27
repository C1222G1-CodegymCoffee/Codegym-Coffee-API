package com.example.codegym_coffee.repository.sale;

import com.example.codegym_coffee.model.TableCoffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ISaleRepository extends JpaRepository<TableCoffee, Integer> {
    @Query(value = "select * from table_coffee", nativeQuery = true)
    List<TableCoffee> findAll();

    @Query(value = "SELECT * FROM table_coffee WHERE id_table = :id", nativeQuery = true)
    TableCoffee findById(int id);

}