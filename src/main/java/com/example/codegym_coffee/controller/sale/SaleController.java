package com.example.codegym_coffee.controller.sale;

import com.example.codegym_coffee.model.TableCoffee;
import com.example.codegym_coffee.service.news.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sale")
@CrossOrigin("*")
public class SaleController {
    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<TableCoffee>> findAllTableCoffee() {
        List<TableCoffee> tableCoffeeList = saleService.findAll();
        if (tableCoffeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableCoffeeList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TableCoffee> findTableCoffeeById(@PathVariable("id") int id) {
        TableCoffee tableCoffee = saleService.findById(id);
        if (tableCoffee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableCoffee,HttpStatus.OK);
    }

}
