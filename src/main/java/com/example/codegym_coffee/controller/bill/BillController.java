package com.example.codegym_coffee.controller.bill;

import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class BillController {
    @Autowired
    private IBillService billService;


    /**
     * @param pageable (10)
     * @return ResponseEntity<>(listBill,HttpStatus.OK)
     * @Author ThanhNV
     * @Date_create: 27/06/2023
     * @Usage_method The method used to show list bill
     */
    @GetMapping("/list-bill")
    public ResponseEntity<Page<Bill>> listBill(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "") String search) {
        pageable = PageRequest.of(page, 10);
        Page<Bill> billPage = billService.showBill(pageable, search);
        return new ResponseEntity<>(billPage, HttpStatus.OK);
    }



    /**
     * @param id
     * @return ResponseEntity<>(Bill, HttpStatus.OK)
     * @Author ThanhNV
     * @Date_create: 27/06/2023
     * @Usage_method The method used to show detail bill
     */
    @GetMapping("/detail-bill/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") Integer id) {
        Bill bill = billService.getBillById(id);
        if (bill == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    /**
     * @param dayOfBill
     * @return ResponseEntity<>(listFeedbackDay,HttpStatus.OK)
     * @Author ThanhNV
     * @Date_create: 27/06/2023
     * @Usage_method The method used to search bill by dayOfBill
     */
    @GetMapping("/bill/search")
    public ResponseEntity<Page<Bill>> searchBill(
            @RequestParam(name = "searchTerm", defaultValue = "") String searchTerm,
            @RequestParam(name = "dayOfBill", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dayOfBill,
            Pageable pageable) {

        Page<Bill> bills;

        if (dayOfBill != null) {
            bills = billService.searchByCodeOrDayAndBill(searchTerm, dayOfBill, pageable);
        } else {
            bills = billService.searchByCodeOrDayOfBill(searchTerm, pageable);
        }

        return ResponseEntity.ok(bills);
    }
}
