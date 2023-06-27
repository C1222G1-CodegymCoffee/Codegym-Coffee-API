package com.example.codegym_coffee.service.news.impl;

import com.example.codegym_coffee.model.TableCoffee;
import com.example.codegym_coffee.repository.sale.ISaleRepository;
import com.example.codegym_coffee.service.news.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService implements ISaleService {
    private final ISaleRepository saleRepository;

    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<TableCoffee> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public TableCoffee findById(int id) {
        return saleRepository.findById(id);
    }


}
