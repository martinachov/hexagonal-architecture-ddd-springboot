package com.martinachov.hexagonal.infrastructure.adapters.output.persistence;

import java.util.Optional;

import com.martinachov.hexagonal.application.ports.output.ProductOutputPort;
import com.martinachov.hexagonal.domain.model.Product;
import com.martinachov.hexagonal.infrastructure.adapters.output.persistence.entity.ProductEntity;
import com.martinachov.hexagonal.infrastructure.adapters.output.persistence.mapper.ProductMapper;
import com.martinachov.hexagonal.infrastructure.adapters.output.persistence.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    
    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        productRepository.save(productEntity);
        return productMapper.toProduct(productEntity);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Product product = productMapper.toProduct(productEntity.get());
        return Optional.of(product);
    }
    
}
