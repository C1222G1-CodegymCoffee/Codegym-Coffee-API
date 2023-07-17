package com.example.codegym_coffee.controller.sale;

import com.example.codegym_coffee.config.MyUserPrincipal;
import com.example.codegym_coffee.dto.sale.BillDTO;
import com.example.codegym_coffee.dto.sale.BillDetailDTO;
import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.model.TableCoffee;
import com.example.codegym_coffee.service.bill.IBillService;
import com.example.codegym_coffee.service.news.IBillDetailService;
import com.example.codegym_coffee.service.news.IBillDTOService;
import com.example.codegym_coffee.service.news.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    private ISaleService saleService;
    @Autowired
    private IBillDetailService billDetailService;

    @Autowired
    private IBillService billService;

    
    @GetMapping("/list")
    public ResponseEntity<List<TableCoffee>> findAllTableCoffee() {
        List<TableCoffee> tableCoffeeList = saleService.findAll();
        if (tableCoffeeList.isEmpty()) {
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableCoffeeList,HttpStatus.OK);
    }

   
    @GetMapping("/search/{id}")
    public ResponseEntity<TableCoffee> findTableCoffeeById(@PathVariable("id") int id) {
        TableCoffee tableCoffee = saleService.findById(id);
        if (tableCoffee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableCoffee,HttpStatus.OK);
    }


   
    @GetMapping("/reset/{tableId}")
    public ResponseEntity<List<BillDetailDTO>> resetTableStatus(@PathVariable("tableId") int tableId) {
        List<BillDetailDTO> billDetails = billDetailService.resetTable(tableId);
        if (billDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(billDetails);
    }

    
    @GetMapping("/bill-details/{tableId}")
    public ResponseEntity<BillDTO> getBillDetailsAndTotalAmountByTableId(@PathVariable("tableId") int tableId) {
        List<BillDetailDTO> billDetails = billDetailService.getBillDetailsAndTotalAmountByTableId(tableId);
        if (billDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(new BillDTO(billDetails, this.billService.getByTableIdAndNonPayment(tableId).getIdBill()));
    }


    @PutMapping("/update/{billId}")
    public ResponseEntity<String> updatePaymentStatusToZero(@PathVariable Integer billId) {
        Bill bill = billService.findBillByIdForPayment(billId); // Retrieve the Bill object from the data source
        if (bill == null) {
            return new ResponseEntity<>("Invalid billId", HttpStatus.BAD_REQUEST);
        }
        if (bill.getPaymentStatus() == 2) {
            return new ResponseEntity<>("Invalid payment status", HttpStatus.BAD_REQUEST);
        }
        saleService.updatePaymentStatusToZero(billId,
                ((MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        return new ResponseEntity<>("Payment status updated successfully", HttpStatus.OK);
    }
}
