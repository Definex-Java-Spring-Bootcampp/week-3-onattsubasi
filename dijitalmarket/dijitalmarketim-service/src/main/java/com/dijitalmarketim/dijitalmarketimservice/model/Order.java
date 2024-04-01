package com.dijitalmarketim.dijitalmarketimservice.model;

import java.util.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private Long orderId;
    private LocalDateTime orderDateTime;
    private List<Product> productList;
    private Double totalPrice;
    private Boolean isDelivered;
    private Customer customer;
    private Bill bill;

    public Order() {
    
    }

    public Order(Long orderId, LocalDateTime orderDate, List<Product> productList, Double totalPrice, Boolean isDelivered, Customer customer, Bill bill) {
        this.orderId = orderId;
        this.orderDateTime = orderDate;
        this.productList = productList;
        this.totalPrice = totalPrice;
        this.isDelivered = isDelivered;
        this.customer = customer;
        this.bill = bill;
    
    }

}
