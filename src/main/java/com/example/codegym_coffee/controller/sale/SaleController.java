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

    /**
     * @author KhaiNLV
     * @body findAllTableCoffee
     * @return return new ResponseEntity<>(tableCoffeeList,HttpStatus.OK)
     * Method to display table list
     * The return result is an object including: success message when displaying the list of success or failure
     */
    @GetMapping("/list")
    public ResponseEntity<List<TableCoffee>> findAllTableCoffee() {
        List<TableCoffee> tableCoffeeList = saleService.findAll();
        if (tableCoffeeList.isEmpty()) {
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableCoffeeList,HttpStatus.OK);
    }

    /**
     * @author KhaiNLV
     * @body findTableCoffeeById
     * @param id The ID of the TableCoffee to be retrieved.
     * @return ResponseEntity<TableCoffee> An HTTP response containing the TableCoffee object if found, or HttpStatus.NO_CONTENT if not found.
     * This method is used to find a TableCoffee object by its ID. It calls the saleService's findById() method to retrieve the TableCoffee.
     * If the TableCoffee is found, it is returned in an HTTP response with HttpStatus.OK. If the TableCoffee is not found,
     * an HTTP response with HttpStatus.NO_CONTENT is returned.
     */
    @GetMapping("/search/{id}")
    public ResponseEntity<TableCoffee> findTableCoffeeById(@PathVariable("id") int id) {
        TableCoffee tableCoffee = saleService.findById(id);
        if (tableCoffee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableCoffee,HttpStatus.OK);
    }


    /**
     * @author KhaiNLV
     * @body resetTableStatus
     * @param tableId The ID of the TableCoffee to reset.
     * @return ResponseEntity<Void> An HTTP response indicating the success or failure of the reset operation.
     * This method is used to reset the status of a TableCoffee identified by the given ID. It calls the saleService's findById() method to retrieve the TableCoffee.
     * If the TableCoffee is not found, an HTTP response with HttpStatus.NOT_FOUND is returned.
     * If the TableCoffee's status is either 1 or 2, the saleService's saveWithStatusReset() method is called to reset the status.
     * The reset operation is considered successful if the TableCoffee's status is reset or if it is not necessary to reset (status is not 1 or 2).
     * An HTTP response with ok is returned to indicate the success of the reset operation.
     */
    @GetMapping("/reset/{tableId}")
    public ResponseEntity<List<BillDetailDTO>> resetTableStatus(@PathVariable("tableId") int tableId) {
        List<BillDetailDTO> billDetails = billDetailService.resetTable(tableId);
        if (billDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(billDetails);
    }

    /**
     * @author KhaiNLV
     * @body getBillDetailsAndTotalAmountByTableId
     * @param tableId The ID of the table for which to retrieve bill details.
     * @return ResponseEntity<List<BillDetailDTO>> An HTTP response containing the list of BillDetailDTO objects and the total amount if found, or HttpStatus.NO_CONTENT if not found.
     * This method is used to retrieve the bill details and total amount for a specific table identified by the given table ID.
     * It calls the billDetailService's getBillDetailsAndTotalAmountByTableId() method to retrieve the list of BillDetailDTO objects and the total amount.
     * If the bill details are not found, an HTTP response with HttpStatus.NO_CONTENT is returned.
     * If the bill details are found, they are returned in an HTTP response with HttpStatus.OK.
     */
    @GetMapping("/bill-details/{tableId}")
    public ResponseEntity<BillDTO> getBillDetailsAndTotalAmountByTableId(@PathVariable("tableId") int tableId) {
        List<BillDetailDTO> billDetails = billDetailService.getBillDetailsAndTotalAmountByTableId(tableId);
        if (billDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(new BillDTO(billDetails, this.billService.getByTableIdAndNonPayment(tableId).getIdBill()));
    }


    /**
     * @author KhaiNLV
     * @body updatePaymentStatusToZero
     * @param billId The ID of the table for which to retrieve bill details.
     * @return ResponseEntity<List<BillDetailDTO>> An HTTP response containing the list of BillDetailDTO objects and the total amount if found, or HttpStatus.NO_CONTENT if not found.
     * This method is used to retrieve the bill details and total amount for a specific table identified by the given table ID.
     * It calls the billDetailService's getBillDetailsAndTotalAmountByTableId() method to retrieve the list of BillDetailDTO objects and the total amount.
     * If the bill details are not found, an HTTP response with HttpStatus.NO_CONTENT is returned.
     * If the bill details are found, they are returned in an HTTP response with HttpStatus.OK.
     */
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
