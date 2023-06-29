package com.example.codegym_coffee.repository;

import com.example.codegym_coffee.dto.satistic.StatisticDTO;
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
     * @Param id_employee
     */
    @Transactional
    @Modifying

//    @Query(value = "SELECT d.dayofbill AS dayOfBill, COALESCE(SUM(bd.quantity_product * bd.price_of_product), 0) AS totalBill\n" +
//            "FROM (\n" +
//            "           SELECT DATE_ADD(:dateBefore, INTERVAL seq.seq DAY) AS dayofbill\n" +
//            "                  FROM (\n" +
//            "                             SELECT @rownum:=@rownum + 1 AS seq\n" +
//            "\t\t\t\t\t\tFROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t1,\n" +
//            "                                 (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t2,\n" +
//            "                                (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t3,\n" +
//            "                                 (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4) t4,\n" +
//            "                                (SELECT @rownum:= -1) r\n" +
//            "                       ) seq\n" +
//            "                   WHERE seq.seq <= DATEDIFF(:dateBefore,:dateAfter)\n" +
//            "                ) AS d LEFT JOIN Bill b ON d.dayofbill = b.day_of_bill\n" +
//            "                   LEFT JOIN bill_detail bd ON b.id_bill = bd.id_bill\n" +
//            "            GROUP BY d.dayofbill", nativeQuery = true)
//    List<StatisticDTO> getListStatistical(@Param("dateAfter") Date dateAfter, @Param("dateBefore") Date dateBefore);
    @Query(value = "select day_of_bill AS dayOfBill, COALESCE(SUM(bill_detail.quantity_product * bill_detail.price_of_product), 0) AS totalBill\n" +
            "            from bill left join bill_detail on bill.id_bill= bill_detail.id_bill where day_of_bill BETWEEN :dateAfter AND :dateBefore group by day_of_bill",nativeQuery = true)
    List<StatisticDTO> getListStatistical(@Param("dateAfter") Date dateAfter, @Param("dateBefore") Date dateBefore);
}