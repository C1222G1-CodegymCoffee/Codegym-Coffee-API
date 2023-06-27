package com.example.codegym_coffee.repository.sale;

import com.example.codegym_coffee.dto.news.BillDetailDTO;
import com.example.codegym_coffee.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {
    @Query(value = "SELECT\n" +
            "  bd.id_bill_detail as idbilldetail,\n" +
            "  p.name_product as nameproduct,\n" +
            "  bd.quantity_product as quantityofproduct,\n" +
            "  p.price,\n" +
            "  t.name_table as nametable,\n" +
            "  bd.quantity_product * p.price AS totalprice,\n" +
            "  (\n" +
            "    SELECT SUM(bd2.quantity_product * p2.price)\n" +
            "    FROM bill_detail bd2\n" +
            "    INNER JOIN bill b2 ON bd2.id_bill = b2.id_bill\n" +
            "    INNER JOIN product p2 ON bd2.id_product = p2.id_product\n" +
            "    INNER JOIN table_coffee t2 ON b2.id_table = t2.id_table\n" +
            "    WHERE t2.id_table = :tableId\n" +
            "  ) AS totalamount\n" +
            "FROM\n" +
            "  bill_detail bd\n" +
            "  INNER JOIN bill b ON bd.id_bill = b.id_bill\n" +
            "  INNER JOIN product p ON bd.id_product = p.id_product\n" +
            "  INNER JOIN table_coffee t ON b.id_table = t.id_table\n" +
            "WHERE\n" +
            "  t.id_table = :tableId",
            countQuery = "SELECT\n" +
                    "  *\n" +
                    "FROM\n" +
                    "  bill_detail bd\n" +
                    "  INNER JOIN bill b ON bd.id_bill = b.id_bill\n" +
                    "  INNER JOIN product p ON bd.id_product = p.id_product\n" +
                    "  INNER JOIN table_coffee t ON b.id_table = t.id_table\n" +
                    "WHERE\n" +
                    "  t.id_table = :tableId", nativeQuery = true)
    List<BillDetailDTO> getBillDetailsAndTotalAmountByTableId(int tableId);
}
