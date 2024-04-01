package com.dijitalmarketim.dijitalmarketimservice.service;

import com.dijitalmarketim.dijitalmarketimservice.client.AkbankServiceClient;
import com.dijitalmarketim.dijitalmarketimservice.client.dto.request.AkbankOrderRequest;
import com.dijitalmarketim.dijitalmarketimservice.client.dto.response.OrderResponse;
import com.dijitalmarketim.dijitalmarketimservice.converter.OrderConverter;
import com.dijitalmarketim.dijitalmarketimservice.dto.request.OrderRequest;
import com.dijitalmarketim.dijitalmarketimservice.model.Order;
import com.dijitalmarketim.dijitalmarketimservice.model.Customer;
import com.dijitalmarketim.dijitalmarketimservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository = new OrderRepository();
    private final OrderConverter orderConverter;
    private final CustomerService customerService;
    private final AkbankServiceClient akbankServiceClient;

    @Override
    public Order createOrder(OrderRequest request) {

        Customer customer = customerService.getByEmail(request.getEmail());
        log.info("customer bulundu");

        Order order = orderConverter.toOrder(request, customer);

        Order savedOrder = orderRepository.save(order);

        OrderResponse akbankOrderResponse = akbankServiceClient.createOrder(prepareAkbankOrderRequest(customer));

        return savedOrder;
    }
    
    private AkbankOrderRequest prepareAkbankOrderRequest(Customer customer) {
        AkbankOrderRequest orderRequest = new AkbankOrderRequest();

        orderRequest.setCustomerId(1L);

        return orderRequest;
    }
}
