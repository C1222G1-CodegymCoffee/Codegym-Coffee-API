package com.example.codegym_coffee.controller.product;

import com.example.codegym_coffee.model.ProductType;
import com.example.codegym_coffee.service.product.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/productType")
public class ProductTypeController {
    @Autowired
    private IProductTypeService productTypeService;
    @GetMapping("")
    public ResponseEntity<List<ProductType>>getAllProductType(){
        List<ProductType> productTypeList = productTypeService.findAllProductType();
        return new ResponseEntity<>(productTypeList, HttpStatus.OK);
    }
}
