package com.dijitalmarketim.dijitalmarketimservice.service;

import com.dijitalmarketim.dijitalmarketimservice.model.Order;
import com.dijitalmarketim.dijitalmarketimservice.client.dto.request.AkbankOrderRequest;
import com.dijitalmarketim.dijitalmarketimservice.dto.request.OrderRequest;
import com.dijitalmarketim.dijitalmarketimservice.model.Customer;

public interface IOrderService {

    Order createOrder(OrderRequest request);

}
