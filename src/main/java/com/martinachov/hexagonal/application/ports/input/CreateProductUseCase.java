package com.martinachov.hexagonal.application.ports.input;

import com.martinachov.hexagonal.domain.model.Product;

public interface CreateProductUseCase {
   
    Product createProduct(Product product);
    
}
