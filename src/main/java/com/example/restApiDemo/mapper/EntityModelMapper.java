package com.example.restApiDemo.mapper;

import com.example.restApiDemo.entity.ProductEntity;
import com.example.restApiDemo.model.Product;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface EntityModelMapper {
    ProductEntity modelToEntity(Product product);
    Product entityToModel(ProductEntity productEntity);


}
