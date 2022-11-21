package com.example.restApiDemo.mapper;

import com.example.restApiDemo.entity.ProductEntity;
import com.example.restApiDemo.model.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-21T12:03:25+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class EntityModelMapperImpl implements EntityModelMapper {

    @Override
    public ProductEntity modelToEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setName( product.getName() );
        productEntity.setQuantity( product.getQuantity() );
        productEntity.setPrice( product.getPrice() );

        return productEntity;
    }

    @Override
    public Product entityToModel(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productEntity.getId() );
        product.setName( productEntity.getName() );
        product.setQuantity( productEntity.getQuantity() );
        product.setPrice( productEntity.getPrice() );

        return product;
    }
}
