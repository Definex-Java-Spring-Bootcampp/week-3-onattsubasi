package com.dijitalmarketim.dijitalmarketimservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dijitalmarketim.dijitalmarketimservice.model.Bill;
import com.dijitalmarketim.dijitalmarketimservice.repository.BillRepository;

@Service
public class BillService implements IBillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
    
        this.billRepository = billRepository;
    
    }

    @Override
    public Bill save(Bill bill)
    {
        billRepository.save(bill);
    
        return bill;
    }
}
