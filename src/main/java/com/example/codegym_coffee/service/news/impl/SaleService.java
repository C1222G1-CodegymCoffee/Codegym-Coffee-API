package com.example.codegym_coffee.service.news.impl;

import com.example.codegym_coffee.model.TableCoffee;
import com.example.codegym_coffee.repository.sale.ISaleRepository;
import com.example.codegym_coffee.service.news.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService {
    @Autowired
    private ISaleRepository saleRepository;

    @Override
    public List<TableCoffee> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public TableCoffee findById(int id) {
        return saleRepository.findById(id);
    }

    @Override
    public void saveWithStatusReset(int id) {
        saleRepository.saveWithStatusReset(id);
    }

    @Override
    public void updatePaymentStatusToZero(int billId, int employeeId) {
        saleRepository.updatePaymentStatusToZero(billId, employeeId);
    }
}
