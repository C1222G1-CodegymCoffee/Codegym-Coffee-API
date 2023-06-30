package com.example.codegym_coffee.service.bill.impl;

import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.repository.bill.IBillRepository;
import com.example.codegym_coffee.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository billRepository;

    @Override
    public Page<Bill> showBill(Pageable pageable, String search) {
        return billRepository.showListBill(pageable, search);
    }

    @Override
    public Page<Bill> findBillByDay(LocalDate dayOfBill, Pageable pageable) {
        return billRepository.findByDayOfBill(dayOfBill, pageable);
    }

    @Override
    public Page<Bill> findBillByCode(String codeBill, Pageable pageable) {
        return billRepository.findByCodeOfBill(codeBill, pageable);
    }

    @Override
    public Bill getBillById(Integer id) {
        return billRepository.findBillById(id);
    }

    @Override
    public Page<Bill> searchByCodeOrDayOfBill(String searchTerm,  Pageable pageable) {
        return billRepository.findBillByCodeOrDay(searchTerm, pageable);
    }

    @Override
    public Page<Bill> searchByCodeOrDayAndBill(String searchTerm, LocalDate dayOfBill, Pageable pageable) {
        return billRepository.findBillByCodeAndDay(searchTerm, dayOfBill, pageable);
    }


}
