package com.martinachov.hexagonal.domain.service;

import com.martinachov.hexagonal.application.ports.input.CreateProductUseCase;
import com.martinachov.hexagonal.application.ports.input.GetProductUseCase;
import com.martinachov.hexagonal.application.ports.output.ProductOutputPort;
import com.martinachov.hexagonal.domain.exception.ProductNotFoundException;
import com.martinachov.hexagonal.domain.model.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase{

    private final ProductOutputPort productOutputPort;
    
    @Override
    public Product getProductById(Long id) {
        System.out.println("Retornando Producto por ID");
        return productOutputPort.getProductById(id)
                                .orElseThrow(() -> new ProductNotFoundException("No se encontro el producto con ID: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println("Creando Producto");
        return productOutputPort.saveProduct(product);
    }
    
}
