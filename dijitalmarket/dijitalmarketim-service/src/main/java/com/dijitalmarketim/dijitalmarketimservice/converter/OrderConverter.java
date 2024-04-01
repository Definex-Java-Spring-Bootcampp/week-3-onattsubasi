package com.dijitalmarketim.dijitalmarketimservice.converter;

import com.dijitalmarketim.dijitalmarketimservice.dto.request.OrderRequest;
import com.dijitalmarketim.dijitalmarketimservice.model.Order;
import com.dijitalmarketim.dijitalmarketimservice.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderConverter {

    public Order toOrder(OrderRequest request, Customer customer) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDateTime(LocalDateTime.now());
        return order;
    }
}
