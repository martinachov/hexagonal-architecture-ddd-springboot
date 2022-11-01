package com.martinachov.hexagonal.application.ports.input;

import com.martinachov.hexagonal.domain.model.Product;

public interface GetProductUseCase {
   
    Product getProductById(Long id);
    
}
