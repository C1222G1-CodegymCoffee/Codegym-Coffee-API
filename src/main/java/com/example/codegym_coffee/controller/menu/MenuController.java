package com.example.codegym_coffee.controller.menu;


import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.model.ProductType;
import com.example.codegym_coffee.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return new ResponseEntity<>(products , HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<>(products , HttpStatus.OK);
    }
    @GetMapping("/type-product")
    public ResponseEntity<List<ProductType>> displayTypeMenu () {
        List<ProductType> productsType = menuService.getAllTypeProduct();
        if(productsType.isEmpty()){
            return new ResponseEntity<>(productsType , HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<>(productsType , HttpStatus.OK);
    }
}
