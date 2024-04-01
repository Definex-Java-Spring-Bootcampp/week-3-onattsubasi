package com.dijitalmarketim.dijitalmarketimservice.controller;

import com.dijitalmarketim.dijitalmarketimservice.model.Customer;
import com.dijitalmarketim.dijitalmarketimservice.service.CustomerService;
import com.dijitalmarketim.dijitalmarketimservice.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    /* @Autowired*/
    private final ICustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) {
        System.out.println("customerService: " + customerService.hashCode());
        return customerService.save(customer);
    }

    @GetMapping
    public List<Customer> getAll() {
    
        return customerService.getAll();
    }

    @GetMapping("/{email}")
    public Customer getByEmail(@PathVariable String email) {
    
        return customerService.getByEmail(email);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Customer> update(@PathVariable String email, @RequestBody Customer customer) {

        Customer customer1 = customerService.update(email, customer);

        if (customer1 != null){
            return ResponseEntity.ok().body(customer1);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{name}")
    public List<Customer> filterByName(@PathVariable String name) {
    
        return customerService.filterByName(name);
    }

    @GetMapping
    public List<Customer> filterByAge(@RequestParam int age1, @RequestParam int age2) {
    
        return customerService.filterByAge(age1, age2);
    }

    
   /* @Autowired
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }*/
}
