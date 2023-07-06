package com.example.codegym_coffee.repository.bill;

import com.example.codegym_coffee.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {

    /**
     * @param pageable (10)
     * @return findAllBill
     * @Author ThanhNV
     * @Date_create: 27/06/2023
     * @Usage_method findAllBill to show list bill
     */
    @Query(value = "select  * from bill ORDER BY day_of_bill DESC"
            , nativeQuery = true)
    Page<Bill> showListBill(Pageable pageable, @Param("search") String search);

    /**
     * @param pageable (10)
     * @return findByDayOfBill
     * @Author ThanhNV
     * @Date_create: 27/06/2023
     * @Usage_method findByDayOfBill to show list bill where day desiderate
     */
    @Query(value = "select * from bill WHERE day_of_bill = :dayOfBill"
            , nativeQuery = true)
    Page<Bill> findByDayOfBill(@Param("dayOfBill") LocalDate dayOfBill, Pageable pageable);


    /**
     * @param pageable (10)
     * @return findByCodeOfBill
     * @Author ThanhNV
     * @Date_create: 27/06/2023
     * @Usage_method findByCodeOfBill to show list bill where code desiderate
     */
    @Query(value = "select * from bill WHERE code_bill = :codeBill"
            , nativeQuery = true)
    Page<Bill> findByCodeOfBill(@Param("codeBill") String codeBill, Pageable pageable);

    @Query(value = "SELECT * FROM bill WHERE id_bill = :id", nativeQuery = true)
    Bill findBillById(@Param("id") Integer id);


    @Query(value = "SELECT * FROM Bill WHERE code_bill LIKE CONCAT('%', :searchTerm, '%') "
            , nativeQuery = true)
    Page<Bill> findBillByCodeOrDay(@Param("searchTerm") String searchTerm,  Pageable pageable);


    @Query(value = "SELECT * FROM Bill WHERE code_bill LIKE CONCAT('%', :searchTerm, '%') AND day_of_bill =:dayOfBill"
            , nativeQuery = true)
    Page<Bill> findBillByCodeAndDay(@Param("searchTerm") String searchTerm, LocalDate dayOfBill, Pageable pageable);


    @Query(value = "SELECT * FROM bill WHERE id_table = :tableId AND payment_status = 0 LIMIT 1", nativeQuery = true)
    Bill getByTableIdAndNonPayment(@Param("tableId") Integer tableId);

    @Query(value = "SELECT * FROM bill WHERE id_bill = :id AND payment_status = 0 LIMIT 1", nativeQuery = true)
    Bill findBillByIdForPayment(@Param("id") Integer id);
@Query(value = "SELECT * FROM bill  ORDER BY id_bill DESC LIMIT 1",nativeQuery = true)
    Bill getNewBill();
}
