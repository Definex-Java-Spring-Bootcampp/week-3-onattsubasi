package com.dijitalmarketim.dijitalmarketimservice.service;

import com.dijitalmarketim.dijitalmarketimservice.model.Customer;
import java.util.List;

public interface ICustomerService {

    public Customer save(Customer customer);

    public List<Customer> getAll();

    public Customer getByEmail(String email);

    public Customer update(String email, Customer customer);

    public List<Customer> filterByName(String name);

    public List<Customer> filterByAge(int age1, int age2);

    public List<Customer> filterByNameandAge(String name, int age1, int age2);
}
