package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.model.TableCoffee;

import java.util.List;

public interface ISaleService {
    List<TableCoffee> findAll();

    TableCoffee findById(int id);

}
