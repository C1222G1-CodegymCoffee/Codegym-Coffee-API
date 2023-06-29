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
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin/bill")
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
    @GetMapping("")
    public ResponseEntity<Page<Bill>> listBill(
            @PageableDefault(size = 5) Pageable pageable,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "") String search) {
        pageable = PageRequest.of(page, 5);
        Page<Bill> billPage = billService.showBill(pageable, search);
        if (billPage.isEmpty()) {
            return new ResponseEntity<>(billPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billPage, HttpStatus.OK);
    }

    /**
     * @param dayOfBill
     * @return ResponseEntity<>(listBillDay,HttpStatus.OK)
     * @Author ThanhNV
     * @Date_create: 27/06/2023
     * @Usage_method The method used to search bill by dayOfBill
     */
    @GetMapping("/day/{dayOfBill}")
    public ResponseEntity<Page<Bill>> getBillByDay(@PathVariable("dayOfBill")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                       LocalDate dayOfBill, Pageable pageable) {
        Page<Bill> listBillDay = billService.findBillByDay(dayOfBill, pageable);
        if (listBillDay.isEmpty()) {
            return new ResponseEntity<>(listBillDay, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listBillDay, HttpStatus.OK);
    }


    /**
     * @param codeBill
     * @return ResponseEntity<>(listBillCode,HttpStatus.OK)
     * @Author ThanhNV
     * @Date_create: 27/06/2023
     * @Usage_method The method used to search bill by codeBill
     */
    @GetMapping("/code/{codeBill}")
    public ResponseEntity<Page<Bill>> getBillByCode(@PathVariable("codeBill")
                                                       String codeBill, Pageable pageable) {
        Page<Bill> listBillCode = billService.findBillByCode(codeBill, pageable);
        if (listBillCode.isEmpty()) {
            return new ResponseEntity<>(listBillCode, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listBillCode, HttpStatus.OK);
    }

    /**
     * @param id
     * @return ResponseEntity<>(Bill, HttpStatus.OK)
     * @Author ThanhNV
     * @Date_create: 27/06/2023
     * @Usage_method The method used to show detail bill
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") Integer id) {
        Bill bill = billService.getBillById(id);
        if (bill == null) {
            System.out.println(bill);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

}
