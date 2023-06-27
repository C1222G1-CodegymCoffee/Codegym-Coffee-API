package com.example.codegym_coffee.service.bill.impl;

import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.repository.bill.IBillRepository;
import com.example.codegym_coffee.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository billRepository;

        @Override
        public Page<Bill> showBill(Pageable pageable) {
            return billRepository.showListBill(pageable);
        }
}
