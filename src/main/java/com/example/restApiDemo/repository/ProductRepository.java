package com.example.restApiDemo.repository;

import com.example.restApiDemo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByName(String name);
}
