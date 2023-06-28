package com.example.codegym_coffee.service.bill;

import com.example.codegym_coffee.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface IBillService {
    Page<Bill> showBill(Pageable pageable, String search);
    Page<Bill> findBillByDay(LocalDate dayOfFeedback, Pageable pageable);
    Page<Bill> findBillByCode(String codeBill, Pageable pageable);

//    Page<Bill> searchBill(Pageable pageable, String search);

//    List<Bill> searchBillByDate(Date day_of_bill);
}
