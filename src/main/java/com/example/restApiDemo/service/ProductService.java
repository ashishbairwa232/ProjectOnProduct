package com.example.restApiDemo.service;

import com.example.restApiDemo.entity.ProductEntity;
import com.example.restApiDemo.model.Product;
import com.example.restApiDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setName(product.getName());
        entity.setQuantity(product.getQuantity());
        entity.setPrice(product.getPrice());

        ProductEntity productEntity = repository.save(entity);
        product.setId(productEntity.getId());

        return product;
    }

    public List<Product> saveProducts(List<Product> products) {

        List<ProductEntity> productEntityList = new ArrayList<>();
        for (Product p : products) {

            ProductEntity entity = new ProductEntity();
            entity.setName(p.getName());
            entity.setQuantity(p.getQuantity());
            entity.setPrice(p.getPrice());
            p.setId(repository.save(entity).getId());
        }
        return products;

    }

    public List<Product> getProducts(String query) {
        List<ProductEntity> productEntityList;
        List<Product> productsList = new ArrayList<Product>();
        Product p = new Product();
        if(query == null) {
            productEntityList = repository.findAll();
            for (ProductEntity e : productEntityList) {

                p.setId(e.getId());
                p.setName(e.getName());
                p.setQuantity(e.getQuantity());
                p.setPrice(e.getPrice());
                productsList.add(p);
            }
//        System.out.println(productEntities.stream().filter(i -> i. ));
        }
    else {
            productEntityList = repository.searchProducts(query);
            for (ProductEntity e : productEntityList) {

                p.setId(e.getId());
                p.setName(e.getName());
                p.setQuantity(e.getQuantity());
                p.setPrice(e.getPrice());
                productsList.add(p);
            }
//        System.out.println(productEntities.stream().filter(i -> i. ));
        }
        return productsList;
    }

    public Product getProductById(int id) {
        ProductEntity entity =  repository.findById(id).orElse(null);
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setQuantity(entity.getQuantity());
        product.setPrice(entity.getPrice());
        return product;
    }

    public Product getProductByName(String name) {

        ProductEntity entity = repository.findByName(name);
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setQuantity(entity.getQuantity());
        product.setPrice(entity.getPrice());
        return product;
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed!! " + id;
    }

    public Product updateProduct(Product product) {
        ProductEntity entity = repository.findById(product.getId()).orElse(null);
       // Product existingProduct = repository.findById(product.getId()).orElse(null);
        entity.setName(product.getName());
        entity.setQuantity(product.getQuantity());
        entity.setPrice(product.getPrice());
        repository.save(entity);
        return product;
    }



}
