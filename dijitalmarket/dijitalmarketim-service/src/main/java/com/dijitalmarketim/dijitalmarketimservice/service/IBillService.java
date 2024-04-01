package com.dijitalmarketim.dijitalmarketimservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dijitalmarketim.dijitalmarketimservice.model.Bill;

public interface IBillService {

    Bill save(Bill bill);

}
