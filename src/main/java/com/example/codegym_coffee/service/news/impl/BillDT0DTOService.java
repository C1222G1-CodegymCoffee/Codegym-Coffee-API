package com.example.codegym_coffee.service.news.impl;

import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.repository.sale.IBillDTORepository;
import com.example.codegym_coffee.service.news.IBillDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDT0DTOService implements IBillDTOService {
    @Autowired
    private IBillDTORepository billRepository;
    @Override
    public Bill findByIdBill(int id) {
        return billRepository.findByIdBill(id);
    }
}
