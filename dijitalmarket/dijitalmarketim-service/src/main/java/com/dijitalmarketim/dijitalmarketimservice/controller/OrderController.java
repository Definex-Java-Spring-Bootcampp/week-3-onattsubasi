package com.dijitalmarketim.dijitalmarketimservice.controller;

import com.dijitalmarketim.dijitalmarketimservice.dto.request.OrderRequest;
import com.dijitalmarketim.dijitalmarketimservice.model.Order;
import com.dijitalmarketim.dijitalmarketimservice.service.OrderService;
import com.dijitalmarketim.dijitalmarketimservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) {
    
        return ResponseEntity.ok().body(orderService.createOrder(request));
    }

}
