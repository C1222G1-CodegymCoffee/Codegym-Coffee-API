package com.example.codegym_coffee.controller.product;

import com.example.codegym_coffee.dto.product.ProductDTO;

import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.service.product.IProductService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private IProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {
        productService.updateProduct(productDTO.getCodeProduct(), productDTO.getIngredient(),
                productDTO.getNameProduct(), productDTO.getPrice(), productDTO.getImage(), productDTO.getProductType().getIdType(), productDTO.getIdProduct());
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    /**
//     * Create by: NghiaLD,
//     * Date create : 28/06/2023
//     * Function : get id from product
//     *
//     * @param id
//     */
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("{id}")
//    public Product findById(@PathVariable("id") Integer id) {
//        return productService.findById(id);
//    }
//
//    /**
//     * Created by: NghiaLD
//     * Date created: 28/06/2023
//     * Function: Update data product into Database*
//     *
//     * @param productDTO
//     * @return
//     */
//    @ResponseStatus(HttpStatus.OK)
//    @PatchMapping("/update/{id}")
//    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {
//        productService.updateProduct(productDTO.getCodeProduct(),
//                productDTO.getNameProduct(), productDTO.getIngredient(), productDTO.getPrice(), productDTO.getImage(), productDTO.getProductType(),productDTO.getIdProduct());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
