package com.dijitalmarketim.dijitalmarketimservice.client;

import com.dijitalmarketim.dijitalmarketimservice.client.dto.request.AkbankOrderRequest;
import com.dijitalmarketim.dijitalmarketimservice.client.dto.response.OrderResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "akbank-service", url = "localhost:8081")
public interface AkbankServiceClient {

    @PostMapping("api/akbank/v1/orders")
    OrderResponse createOrder(@RequestBody AkbankOrderRequest request);
}
