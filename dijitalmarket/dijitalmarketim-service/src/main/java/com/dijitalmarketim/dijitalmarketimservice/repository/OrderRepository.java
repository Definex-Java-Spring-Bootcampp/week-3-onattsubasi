package com.dijitalmarketim.dijitalmarketimservice.repository;

import com.dijitalmarketim.dijitalmarketimservice.model.Order;

import java.util.List;
import java.util.ArrayList;

public class OrderRepository {

    private List<Order> orderList = new ArrayList<>();

    public Order save(Order order) {
        orderList.add(order);
        return order;
    }

    public List<Order> getAll() {
        return orderList;
    }

    public void delete(Order order) {
        orderList.remove(order);
    }

    public Order findByOrderId(Long orderId) {
        return new Order();
    }
}
