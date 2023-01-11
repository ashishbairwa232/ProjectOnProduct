package com.example.restApiDemo.service;

import com.example.restApiDemo.entity.ProductEntity;
import com.example.restApiDemo.mapper.EntityModelMapper;
import com.example.restApiDemo.model.Product;
import com.example.restApiDemo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;



@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository repository;
    @Autowired
    private EntityModelMapper entityModelMapper;

    public Product saveProduct(Product product) {
        logger.info("save product on database");

        ProductEntity entity =  entityModelMapper.modelToEntity(product);
//        entity.setName(product.getName());
//        entity.setQuantity(product.getQuantity());
//        entity.setPrice(product.getPrice());


        ProductEntity productEntity = repository.save(entity);
        product.setId(productEntity.getId());

        return product;
    }

    public List<Product> saveProducts(List<Product> products) {

        List<ProductEntity> productEntityList = new ArrayList<>();
        for (Product p : products) {

            ProductEntity entity = entityModelMapper.modelToEntity(p);
//            entity.setName(p.getName());
//            entity.setQuantity(p.getQuantity());
//            entity.setPrice(p.getPrice());
            p.setId(repository.save(entity).getId());
        }
        return products;

    }

    public List<Product> getProducts(String query) {
        List<ProductEntity> productEntityList;
        List<Product> productsList = new ArrayList<Product>();

        productEntityList  = query == null ? repository.findAll() : repository.searchProducts(query);
        for (ProductEntity e : productEntityList) {
            Product p = entityModelMapper.entityToModel(e);
//            p.setId(e.getId());
//            p.setName(e.getName());
//            p.setQuantity(e.getQuantity());
//            p.setPrice(e.getPrice());
            productsList.add(p);
        }

        return productsList;
    }

    public Product getProductById(int id) {
        ProductEntity entity =  repository.findById(id).orElse(null);
        Product product = entityModelMapper.entityToModel(entity);
//        product.setId(entity.getId());
//        product.setName(entity.getName());
//        product.setQuantity(entity.getQuantity());
//        product.setPrice(entity.getPrice());
        return product;
    }

    public Product getProductByName(String name) {

        ProductEntity entity = repository.findByName(name);
        Product product = entityModelMapper.entityToModel(entity);
//        product.setId(entity.getId());
//        product.setName(entity.getName());
//        product.setQuantity(entity.getQuantity());
//        product.setPrice(entity.getPrice());
        return product;
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed!! " + id;
    }

    public Product updateProduct(Product product) {
        ProductEntity entity = repository.findById(product.getId()).orElse(null);
       // Product existingProduct = repository.findById(product.getId()).orElse(null);
//        entity.setName(product.getName());
//        entity.setQuantity(product.getQuantity());
//        entity.setPrice(product.getPrice());
        entity = entityModelMapper.modelToEntity(product);
        repository.save(entity);
        return product;
    }
    public Product partialProductUpdate(int id , Product product) {
        ProductEntity entity = repository.findById(id).orElse(null);

        boolean needUpdate = false;

        if (StringUtils.hasLength(product.getName())) {
            entity.setName(product.getName());
            needUpdate = true;
        }

        if (product.getQuantity()>0) {
            entity.setQuantity(product.getQuantity());
            needUpdate = true;
        }

        if (product.getPrice()>0) {
            entity.setPrice(product.getPrice());
            needUpdate = true;
        }

        if (needUpdate) {
            repository.save(entity);
        }
//        product.setId(id);
//        product.setName( entity.getName());
//        product.setQuantity(entity.getQuantity());
//        product.setPrice(entity.getPrice());
        product = entityModelMapper.entityToModel(entity);
        return product;
    }
}
