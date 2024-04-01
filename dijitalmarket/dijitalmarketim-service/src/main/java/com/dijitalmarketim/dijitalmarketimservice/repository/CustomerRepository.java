package com.dijitalmarketim.dijitalmarketimservice.repository;

import com.dijitalmarketim.dijitalmarketimservice.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    public void save(Customer customer) {
        customerList.add(customer);
    
    }

    public List<Customer> getAll() {
    
        return customerList;
    }

    public Optional<Customer> findByEmail(String email) {
    
        return customerList.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
    }

    public void delete(Customer customer) {
        customerList.remove(customer);
    
    }
/*
    public Customer findByCustomerId(Long customerId) {
    
        return new Customer();
    }*/

    public List<Customer> filterByName(String name){
        
            return customerList.stream()
                    .filter(customer -> customer.getName().equals(name))
                    .toList();
    }


}
