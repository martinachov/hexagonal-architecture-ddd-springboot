package com.martinachov.hexagonal.infrastructure.adapters.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.martinachov.hexagonal.domain.service.ProductService;
import com.martinachov.hexagonal.infrastructure.adapters.output.persistence.ProductPersistenceAdapter;
import com.martinachov.hexagonal.infrastructure.adapters.output.persistence.mapper.ProductMapper;
import com.martinachov.hexagonal.infrastructure.adapters.output.persistence.repository.ProductRepository;

/**
 * Configuracion BEANS
 */
@Configuration
public class BeanConfiguration {
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ProductMapper productMapper(){
        return new ProductMapper();
    }
    
    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        return new ProductPersistenceAdapter(productRepository, productMapper);
    }

    @Bean
    public ProductService productService(ProductPersistenceAdapter productPersistenceAdapter) {
        return new ProductService(productPersistenceAdapter);
    }

}
