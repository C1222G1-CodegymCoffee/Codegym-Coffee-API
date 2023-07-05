package com.example.codegym_coffee.repository.sale;

import com.example.codegym_coffee.model.TableCoffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ISaleRepository extends JpaRepository<TableCoffee,Integer> {
    @Query(value = "SELECT * FROM table_coffee", nativeQuery = true)
    List<TableCoffee> findAll();

    @Query(value = "SELECT * FROM table_coffee WHERE id_table = :id", nativeQuery = true)
    TableCoffee findById(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE table_coffee SET status = 2 WHERE status IN (1, 0) AND id_table = :id", nativeQuery = true)
    void saveWithStatusReset(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bill AS b\n" +
            "JOIN `table_coffee` AS t ON b.id_table = t.id_table\n" +
            "SET b.payment_status = 1, t.status = 0, b.employee_id = :employeeId " +
            "WHERE b.id_bill = :billId",nativeQuery = true)
    void updatePaymentStatusToZero(@Param("billId") int billId, @Param("employeeId") int employeeId);



}
