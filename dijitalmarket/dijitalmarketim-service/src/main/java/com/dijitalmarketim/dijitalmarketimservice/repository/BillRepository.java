package com.dijitalmarketim.dijitalmarketimservice.repository;

import com.dijitalmarketim.dijitalmarketimservice.model.Bill;
import java.util.List;
import java.util.ArrayList;

public class BillRepository {

    private List<Bill> billList = new ArrayList<>();

    public void save(Bill bill) {
        billList.add(bill);
    }

    public List<Bill> getAll() {
        return billList;
    }

    public void delete(Bill bill) {
        billList.remove(bill);
    }
}
