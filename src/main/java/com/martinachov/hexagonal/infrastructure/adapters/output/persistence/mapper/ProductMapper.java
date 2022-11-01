package com.martinachov.hexagonal.infrastructure.adapters.output.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.martinachov.hexagonal.domain.model.Product;
import com.martinachov.hexagonal.infrastructure.adapters.output.persistence.entity.ProductEntity;

public class ProductMapper {

    @Autowired
    private ModelMapper mapper;

    public Product toProduct(ProductEntity entity){
        return mapper.map(entity, Product.class);
    }
    
    public ProductEntity toEntity(Product product){
        return mapper.map(product, ProductEntity.class);
    }

}
