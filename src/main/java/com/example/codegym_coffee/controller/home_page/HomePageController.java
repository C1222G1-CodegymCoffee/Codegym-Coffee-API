package com.example.codegym_coffee.controller.home_page;

import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.service.home_page.IHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class HomePageController {
    @Autowired
    private IHomePageService homePageService;

    @GetMapping("/topProduct")
    public ResponseEntity<List<Product>> getTopProduct() {
        List<Product> topProductList = homePageService.findTopProduct();
        if (topProductList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(topProductList, HttpStatus.OK);
    }

    @GetMapping("/newProduct")
    public ResponseEntity<List<Product>> getNewProduct() {
        List<Product> newProductList = homePageService.findNewProduct();
        if (newProductList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newProductList, HttpStatus.OK);
    }
}
