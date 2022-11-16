package com.example.restApiDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product_TBl")
public class ProductEntity {
     @Id
     @GeneratedValue
     private int id;
     private String name;
     private int quantity;
     private  double price;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getQuantity() {
          return quantity;
     }

     public void setQuantity(int quantity) {
          this.quantity = quantity;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }

     @Override
     public String toString() {
          return "ProductEntity{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", quantity=" + quantity +
                  ", price=" + price +
                  '}';
     }
}
