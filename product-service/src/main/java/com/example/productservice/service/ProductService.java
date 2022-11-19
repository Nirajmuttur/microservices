package com.example.productservice.service;

import com.example.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(Product product);
    void updateProduct(Product product);

    void deleteProduct(Long id);

    void deleteProductByFactoryId(Long id);

    List<Product> getProductByFactoryId(Long id);
}
