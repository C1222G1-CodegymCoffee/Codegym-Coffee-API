package com.example.codegym_coffee.controller.product;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping("/product-create")
    public ResponseEntity<List<ObjectError>> createProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: NghiaLD,
     * Date create : 28/06/2023
     * Function : get id from product
     *
     * @param id
     */

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Created by: NghiaLD
     * Date created: 28/06/2023
     * Function: Update data product into Database*
     *
     * @param productDTO
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/product-update/{idProduct}")
    public ResponseEntity<List<ObjectError>> updateProduct(@PathVariable Integer idProduct, @Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        new ProductDTO().validate(productDTO, bindingResult);
        productDTO.setIdProduct(idProduct);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDTO.getNameProduct(), productDTO.getIngredient(),
                productDTO.getPrice(), productDTO.getImage(), productDTO.getProductTypeDTO().getIdType(), productDTO.getIdProduct());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
