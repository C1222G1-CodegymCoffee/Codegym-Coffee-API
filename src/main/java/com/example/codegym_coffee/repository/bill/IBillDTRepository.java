package com.example.codegym_coffee.repository.bill;

import com.example.codegym_coffee.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillDTRepository extends JpaRepository<BillDetail,Integer> {
    @Query(value = "SELECT bd.* from bill_detail bd join bill b on bd.id_bill = b.id_bill where bd.id_bill = ?1",nativeQuery = true)
    List<BillDetail> getByIdBill(Integer idBill);
}
