package com.example.productservice.controller;

import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/product")
@Transactional
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    private ResponseEntity<Object> createProduct(@RequestPart("factoryId") Long factoryId, @RequestPart("product") Product product){
        try {

            product.setFactoryID(factoryId);
            Product newProduct=productService.addProduct(product);
            return new ResponseEntity<>(newProduct, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Error creating product", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value ="/factory/{factoryID}")
    private ResponseEntity<Object> getProductByFactoryId(@PathVariable("factoryID") Long factoryID){
        List<Product> product=productService.getProductByFactoryId(factoryID);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping(value = "/factory/{factoryID}")
    private ResponseEntity<Object> deleteProductByFactoryId(@PathVariable("factoryID") Long factoryID){
        productService.deleteProductByFactoryId(factoryID);

        return new ResponseEntity<>("product deleted",HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{productId}")
    private ResponseEntity<Object> deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/")
    private ResponseEntity<Object> getProductdummy(){
        return new ResponseEntity<>("Hello ",HttpStatus.OK);
    }
}
