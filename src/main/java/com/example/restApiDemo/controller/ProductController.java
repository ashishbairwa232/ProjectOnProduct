package com.example.restApiDemo.controller;

import com.example.restApiDemo.model.Product;
import com.example.restApiDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProducts(@PathParam("query") String query) {
        return ResponseEntity.ok(service.getProducts(query));
    }
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id)
    {
        return service.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name)
    {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        return service.deleteProduct(id);
    }


}
