package com.example.codegym_coffee.controller.product;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.model.ProductType;
import com.example.codegym_coffee.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductController {
//    @Autowired
//    private IProductService productService;
//    @PostMapping("/create")
//    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
//        new ProductDTO().validate(productDTO, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
//        }
//        productService.createProduct(productDTO.getIngredient(), productDTO.getNameProduct(),
//                productDTO.getPrice(), productDTO.getImage(), productDTO.getProductType());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
