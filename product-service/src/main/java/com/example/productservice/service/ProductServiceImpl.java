package com.example.productservice.service;

import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> product=productRepository.findProductById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException();
        }

        productRepository.deleteById(id);

    }

    @Override
    public void deleteProductByFactoryId(Long id) {
        productRepository.deleteProductByFactoryID(id);
    }

    @Override
    public List<Product> getProductByFactoryId(Long id) {
        return productRepository.findProductByFactoryID(id);
    }


}
