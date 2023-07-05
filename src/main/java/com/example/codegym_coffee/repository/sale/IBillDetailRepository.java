package com.example.codegym_coffee.repository.sale;

import com.example.codegym_coffee.dto.sale.BillDetailDTO;
import com.example.codegym_coffee.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {
    @Query(value = "SELECT\n" +
            "    bd.id_bill_detail AS idbilldetail,\n" +
            "    p.name_product AS nameproduct,\n" +
            "    bd.quantity_product AS quantityofproduct,\n" +
            "    p.price,\n" +
            "    t.name_table AS nametable,\n" +
            "    bd.quantity_product * p.price AS totalprice,\n" +
            "    CASE\n" +
            "        WHEN b.payment_status = 0 THEN\n" +
            "            (\n" +
            "                SELECT SUM(bd2.quantity_product * p2.price)\n" +
            "                FROM bill_detail bd2\n" +
            "                INNER JOIN bill b2 ON bd2.id_bill = b2.id_bill\n" +
            "                INNER JOIN product p2 ON bd2.id_product = p2.id_product\n" +
            "                INNER JOIN table_coffee t2 ON b2.id_table = t2.id_table\n" +
            "                WHERE t2.id_table = :tableId AND b2.payment_status = 1\n" +
            "            )\n" +
            "        ELSE\n" +
            "            0\n" +
            "    END AS totalamount\n" +
            "FROM\n" +
            "    bill_detail bd\n" +
            "    INNER JOIN bill b ON bd.id_bill = b.id_bill\n" +
            "    INNER JOIN product p ON bd.id_product = p.id_product\n" +
            "    INNER JOIN table_coffee t ON b.id_table = t.id_table\n" +
            "WHERE\n" +
            "    t.id_table = :tableId\n" +
            "    AND b.payment_status = 0",
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

    @Query(value = "SELECT\n" +
            "    bd.id_bill_detail AS idbilldetail,\n" +
            "    p.name_product AS nameproduct,\n" +
            "    bd.quantity_product AS quantityofproduct,\n" +
            "    p.price,\n" +
            "    t.name_table AS nametable,\n" +
            "    bd.quantity_product * p.price AS totalprice,\n" +
            "    CASE\n" +
            "        WHEN b.payment_status = 1 THEN\n" +
            "            (\n" +
            "                SELECT SUM(bd2.quantity_product * p2.price)\n" +
            "                FROM bill_detail bd2\n" +
            "                INNER JOIN bill b2 ON bd2.id_bill = b2.id_bill\n" +
            "                INNER JOIN product p2 ON bd2.id_product = p2.id_product\n" +
            "                INNER JOIN table_coffee t2 ON b2.id_table = t2.id_table\n" +
            "                WHERE t2.id_table = :tableId AND b2.payment_status = 1\n" +
            "            )\n" +
            "        ELSE\n" +
            "            0\n" +
            "    END AS totalamount\n" +
            "FROM\n" +
            "    bill_detail bd\n" +
            "    INNER JOIN bill b ON bd.id_bill = b.id_bill\n" +
            "    INNER JOIN product p ON bd.id_product = p.id_product\n" +
            "    INNER JOIN table_coffee t ON b.id_table = t.id_table\n" +
            "WHERE\n" +
            "    t.id_table = :tableId\n" +
            "    AND b.payment_status = 1",
            countQuery = "SELECT\n" +
                    "  *\n" +
                    "FROM\n" +
                    "  bill_detail bd\n" +
                    "  INNER JOIN bill b ON bd.id_bill = b.id_bill\n" +
                    "  INNER JOIN product p ON bd.id_product = p.id_product\n" +
                    "  INNER JOIN table_coffee t ON b.id_table = t.id_table\n" +
                    "WHERE\n" +
                    "  t.id_table = :tableId", nativeQuery = true)
    List<BillDetailDTO> resetTable(int tableId);


}
