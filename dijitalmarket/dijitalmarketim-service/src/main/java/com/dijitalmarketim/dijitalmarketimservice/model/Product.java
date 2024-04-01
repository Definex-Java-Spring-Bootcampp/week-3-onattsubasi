package com.dijitalmarketim.dijitalmarketimservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long productId;
    private String productName;
    private Double price;
    private Integer stock;
    private String description;
    private String category;
    private String brand;

    public Product() {
    
    }

    public Product(Long productId, String productName, Double price, Integer stock, String description, String category, String brand) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category = category; 
        this.brand = brand;
    
    }

}
