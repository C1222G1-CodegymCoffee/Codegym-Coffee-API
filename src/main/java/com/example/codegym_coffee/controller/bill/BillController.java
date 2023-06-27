package com.example.codegym_coffee.controller.bill;

import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/bill")
@CrossOrigin("*")
public class BillController {
    @Autowired
    private IBillService billService;

//    @GetMapping("/")
//    public ResponseEntity<Page<Bill>> showAll(@PageableDefault(size = 10) Pageable pageable, @RequestParam(value = "page", defaultValue = "0") int page) {
//        pageable = PageRequest.of(page, 10);
//        Page<Bill> billPage = billService.showBill(pageable);
//        if (billPage.isEmpty()){
//            return new ResponseEntity<>(billPage, HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(billPage, HttpStatus.OK);
//    }

    @GetMapping("/")
    public ResponseEntity<Page<Bill>> list(@PageableDefault(size = 10) Pageable pageable, @RequestParam(value = "page", defaultValue = "0") int page) {
        pageable = PageRequest.of(page, 10);
        Page<Bill> billPage = billService.showBill(pageable);
        if (billPage.isEmpty()) {
            return new ResponseEntity<>(billPage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(billPage, HttpStatus.OK);
    }
}
