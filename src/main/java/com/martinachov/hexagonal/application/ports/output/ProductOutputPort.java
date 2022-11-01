package com.martinachov.hexagonal.application.ports.output;

import java.util.Optional;

import com.martinachov.hexagonal.domain.model.Product;

public interface ProductOutputPort {
    
    Product saveProduct(Product product);
    
    Optional<Product> getProductById(Long id);
    
}
