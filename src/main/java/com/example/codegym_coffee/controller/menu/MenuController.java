package com.example.codegym_coffee.controller.menu;


import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.model.BillDetail;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import com.example.codegym_coffee.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {

    @Autowired
    private IMenuService menuService ;

    @GetMapping("")
    public ResponseEntity<List<Product>> displayMenu (){
        List<Product> products = menuService.getAllProduct();
        if(products.isEmpty()){
            return new ResponseEntity<>(products , HttpStatus.BAD_REQUEST);
        }
        return new  ResponseEntity<>(products , HttpStatus.OK);
    }
    @GetMapping("/type-product")
    public ResponseEntity<List<ProductType>> displayTypeMenu () {
        List<ProductType> productsType = menuService.getAllTypeProduct();
        if(productsType.isEmpty()){
            return new ResponseEntity<>(productsType , HttpStatus.BAD_REQUEST);
        }
        return new  ResponseEntity<>(productsType , HttpStatus.OK);
    }
    @GetMapping("/product-by-type")
    public ResponseEntity<List<Product>> displayProductByType(@RequestParam(name = "type") String type){
        List<Product> products = menuService.getProductByTypeProduct(type);
        if(products.isEmpty()){
            return new ResponseEntity<>(products , HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<>(products , HttpStatus.OK);
    }
    @PostMapping("/add-to-bill")
    public ResponseEntity<BillDetail> addToBill(@RequestBody List<Product> products){
        Bill bill = new Bill(1);
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            menuService.addBillDetail(new BillDetail(12,product.getPrice(),bill,product));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
