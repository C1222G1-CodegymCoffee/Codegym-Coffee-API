package com.example.codegym_coffee.controller.menu;


import com.example.codegym_coffee.dto.menu.ProductMenuDto;
import com.example.codegym_coffee.model.*;
import com.example.codegym_coffee.service.menu.IMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping("")
    public ResponseEntity<List<Product>> displayMenu() {
        List<Product> products = menuService.getAllProduct();
        if (products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/type-product")
    public ResponseEntity<List<ProductType>> displayTypeMenu() {
        List<ProductType> productsType = menuService.getAllTypeProduct();
        if (productsType.isEmpty()) {
            return new ResponseEntity<>(productsType, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productsType, HttpStatus.OK);
    }

    @GetMapping("/product-by-type")
    public ResponseEntity<List<Product>> displayProductByType(@RequestParam(name = "type") String type) {
        List<Product> products = menuService.getProductByTypeProduct(type);
        if (products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/add-to-bill")
    public ResponseEntity<ProductMenuDto> addToBill(@RequestBody List<ProductMenuDto> listProductMenuDto) {
        TableCoffee tableCoffee = menuService.getTableCoffee(listProductMenuDto.get(0).getTableOfBill());
        LocalDate localDate = LocalDate.now();
        Bill bill = new Bill(localDate, 1, null, null, tableCoffee);
        menuService.createBill(bill);
        Bill billToAddBD = menuService.getBillByTable(tableCoffee.getIdTable());

        for (int i = 0; i < listProductMenuDto.size(); i++) {
            ProductMenuDto productMenuDto = listProductMenuDto.get(i);
            Product product = new Product();
            BeanUtils.copyProperties(productMenuDto,product);
            menuService.addBillDetail(new BillDetail(productMenuDto.getQuantityOfProduct(),product.getPrice(),billToAddBD,product));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}