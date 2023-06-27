package com.example.codegym_coffee.controller.sale;

import com.example.codegym_coffee.dto.news.BillDetailDTO;
import com.example.codegym_coffee.model.BillDetail;
import com.example.codegym_coffee.model.TableCoffee;
import com.example.codegym_coffee.service.news.IBillDetailService;
import com.example.codegym_coffee.service.news.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    private ISaleService saleService;
    @Autowired
    private IBillDetailService billDetailService;

    @GetMapping("/list")
    public ResponseEntity<List<TableCoffee>> findAllTableCoffee() {
        List<TableCoffee> tableCoffeeList = saleService.findAll();
        if (tableCoffeeList.isEmpty()) {
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableCoffeeList,HttpStatus.OK);
    }
    @GetMapping("search/{id}")
    public ResponseEntity<TableCoffee> findTableCoffeeById(@PathVariable("id") int id) {
        TableCoffee tableCoffee = saleService.findById(id);
        if (tableCoffee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableCoffee,HttpStatus.OK);
    }
    @PostMapping("/reset/{id}")
    public ResponseEntity<Void> resetTableStatus(@PathVariable("id") int id) {
        TableCoffee tableCoffee = saleService.findById(id);
        if (tableCoffee == null) {
            return ResponseEntity.notFound().build();
        }
        if (tableCoffee.getStatus() == 1 || tableCoffee.getStatus() == 2) {
            saleService.saveWithStatusReset(id);
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping("/bill-details/{tableId}")
    public ResponseEntity<List<BillDetailDTO>> getBillDetailsAndTotalAmountByTableId(@PathVariable("tableId") int tableId) {
        List<BillDetailDTO> billDetails = billDetailService.getBillDetailsAndTotalAmountByTableId(tableId);
        if (billDetails == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billDetails,HttpStatus.OK);
    }
}
