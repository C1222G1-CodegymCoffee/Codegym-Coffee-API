package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.model.TableCoffee;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ISaleService {
    List<TableCoffee> findAll();
    TableCoffee findById(int id);
}
