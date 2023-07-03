package com.example.codegym_coffee.repository;

import com.example.codegym_coffee.dto.satistic.StaticDTO;
import com.example.codegym_coffee.model.BillDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface IStatisticalRepository extends JpaRepository<BillDetail, Integer> {
    /**
     * create by : ThongDM ,
     * Date Create : 27/06/2023
     * Function : Daily revenue statistics
     * @Param day_of_bill
     */
    @Transactional
    @Modifying

//    @Query(value = "SELECT d.dayofbill AS dayOfBill, COALESCE(SUM(bd.quantity_product * bd.price_of_product), 0) AS totalBill\n" +
//            "FROM (\n" +
//            "    SELECT DATE_ADD(:dateBefore, INTERVAL seq.seq DAY) AS dayofbill\n" +
//            "    FROM (\n" +
//            "        SELECT (@rownum:=@rownum + 1) AS seq\n" +
//            "        FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t1,\n" +
//            "        (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t2,\n" +
//            "        (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t3,\n" +
//            "        (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t4,\n" +
//            "        (SELECT (@rownum:=-1)) r\n" +
//            "    ) seq\n" +
//            "    WHERE seq.seq <= DATEDIFF(:dateBefore, :dateAfter)\n" +
//            ") AS d\n" +
//            "LEFT JOIN Bill b ON d.dayofbill = b.day_of_bill\n" +
//            "LEFT JOIN bill_detail bd ON b.id_bill = bd.id_bill\n" +
//            "GROUP BY d.dayofbill\n", nativeQuery = true)
//    List<StaticDTO> getListStatistical(@Param("dateAfter") Date dateAfter, @Param("dateBefore") Date dateBefore);
//    @Query(value = "SELECT d.dayofbill AS dayOfBill, COALESCE (SUM(bd.quantity_product * bd.price_of_product), 0) AS totalBill FROM ( SELECT DATE_ADD(:dateBefore, INTERVAL seq.seq DAY) AS dayofbill FROM ( SELECT (@rownum::=@rownum+1) AS seq FROM ( SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t1 CROSS JOIN ( SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t2 CROSS JOIN ( SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t3 CROSS JOIN ( SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t4 CROSS JOIN (SELECT (@rownum::=-1)) r) seq WHERE seq.seq <= DATEDIFF(:dateBefore, :dateAfter)) AS d LEFT JOIN Bill b ON d.dayofbill = b.day_of_bill LEFT JOIN bill_detail bd ON b.id_bill = bd.id_bill GROUP BY d.dayofbill;",nativeQuery = true)
    @Query(value = "select day_of_bill AS name, COALESCE(SUM(bill_detail.quantity_product * bill_detail.price_of_product), 0) AS `value`\n" +
            "            from bill left join bill_detail on bill.id_bill= bill_detail.id_bill where day_of_bill BETWEEN :dateAfter AND :dateBefore group by day_of_bill",nativeQuery = true)
    List<StaticDTO> getListStatistical(@Param("dateAfter") Date dateAfter, @Param("dateBefore") Date dateBefore);
}