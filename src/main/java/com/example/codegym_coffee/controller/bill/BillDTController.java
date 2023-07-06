package com.example.codegym_coffee.controller.bill;

import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.model.BillDetail;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.service.bill.IBillDTService;
import com.example.codegym_coffee.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BillDTController {
    @Autowired
    IBillDTService billDTService;
    @Autowired
    IBillService billService;
    @GetMapping("/ListBillDetail")
    public ResponseEntity<List<BillDetail>> getBillDetail() {
        Bill bill = billService.getBill();
        List<BillDetail> billDetailList = billDTService.getBillDetail(bill.getIdBill());
        return new ResponseEntity<>(billDetailList, HttpStatus.OK);
    }

}
