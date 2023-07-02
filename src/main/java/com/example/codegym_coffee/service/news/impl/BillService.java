package com.example.codegym_coffee.service.news.impl;

import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.repository.sale.IBillRepository;
import com.example.codegym_coffee.service.news.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository billRepository;
    @Override
    public Bill findByIdBill(int id) {
        return billRepository.findByIdBill(id);
    }
}
