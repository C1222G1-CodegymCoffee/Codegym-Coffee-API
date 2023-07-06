package com.example.codegym_coffee.service.bill;

import com.example.codegym_coffee.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface IBillService {
    Page<Bill> showBill(Pageable pageable, String search);
    Page<Bill> findBillByDay(LocalDate dayOfFeedback, Pageable pageable);
    Page<Bill> findBillByCode(String codeBill, Pageable pageable);

    Bill getBillById(Integer id);

    Page<Bill> searchByCodeOrDayOfBill(String searchTerm, Pageable pageable);

    Page<Bill> searchByCodeOrDayAndBill(String searchTerm,LocalDate dayOfBill, Pageable pageable);

    Bill getByTableIdAndNonPayment(Integer tableId);

    Bill findBillByIdForPayment(Integer id);

    Bill getBill();
}
