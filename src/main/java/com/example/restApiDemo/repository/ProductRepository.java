package com.example.restApiDemo.repository;

import com.example.restApiDemo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByName(String name);

    @Query("SELECT p FROM ProductEntity p WHERE " +
            "p.name LIKE CONCAT('%',:query, '%')" +
            "Or p.quantity LIKE CONCAT('%', :query, '%')"+"Or p.price LIKE CONCAT('%', :query, '%')")
    List<ProductEntity> searchProducts(String query);
}
