package com.dijitalmarketim.dijitalmarketimservice.service;

import com.dijitalmarketim.dijitalmarketimservice.exceptions.ExceptionMessages;
import com.dijitalmarketim.dijitalmarketimservice.exceptions.DijitalmarketimException;
import com.dijitalmarketim.dijitalmarketimservice.model.Customer;
import com.dijitalmarketim.dijitalmarketimservice.producer.NotificationProducer;
import com.dijitalmarketim.dijitalmarketimservice.producer.dto.NotificationDTO;
import com.dijitalmarketim.dijitalmarketimservice.producer.enums.NotificationType;
import com.dijitalmarketim.dijitalmarketimservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
@Scope(value = "singleton")
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository = new CustomerRepository();

    private final NotificationProducer notificationProducer;

    @Override
    public Customer save(Customer customer) {
        System.out.println("customerRepository: " + customerRepository.hashCode());

        customerRepository.save(customer);

        notificationProducer.sendNotification(prepareNotificationDTO(NotificationType.EMAIL, customer.getEmail()));

        return customer;
    }

    private NotificationDTO prepareNotificationDTO(NotificationType notificationType, String email) {
        return NotificationDTO.builder()
                .message("customer kaydedildi.")
                .notificationType(notificationType)
                .email(email)
                .build();
    }

    @Override
    public List<Customer> getAll() {
        System.out.println("customerRepository: " + customerRepository.hashCode());
        return customerRepository.getAll();
    }

    @Override
    public Customer getByEmail(String email) {

        Optional<Customer> foundCustomer = customerRepository.findByEmail(email);

        Customer customer = foundCustomer.orElseThrow(() -> new DijitalmarketimException(ExceptionMessages.USER_NOT_FOUND));

        if (foundCustomer.isPresent()) {
            customer = foundCustomer.get();
        }

        //throw new RuntimeException();

        // throw new NullPointerException();

         throw new IllegalArgumentException("exception fırlatıldı");

        // throw new ArithmeticException();

       // return customer;

    }

    @Override
    public Customer update(String email, Customer customer) {

        Optional<Customer> foundCustomer = customerRepository.findByEmail(email);

        foundCustomer.get().setName(customer.getName());

        foundCustomer.get().setSurname(customer.getSurname());

        customerRepository.delete(customer);

        customerRepository.save(foundCustomer.get());

        return foundCustomer.get();
    }
/*
    public Customer getById(Long customerId) {
    
        return customerRepository.findByCustomerId(customerId);
    } */

    @Override
    public List<Customer> filterByName(String name) {
    
        return customerRepository.filterByName(name);
    }

    @Override
    public List<Customer> filterByAge(int age1, int age2) {
    
        if(age1 < 0 || age2 < 0){
            throw new IllegalArgumentException("Yaş değerleri negatif olamaz.");
        
        }else {

            List<Customer> filteredList = new ArrayList<>();
            int today = LocalDate.now().getYear();
        
            if(age1 > age2){
                int temp = age1;
                age1 = age2;
                age2 = temp;
            
            }

        for (Customer customer : customerRepository.getAll()) {
            
            if (today - (customer.getBirthDate().getYear()) >= age1 &&
             today - (customer.getBirthDate().getYear()) <= age2) {
                
                filteredList.add(customer);
            
                }
        
            }
        
        return filteredList;
        }
        
    }

    @Override
    public List<Customer> filterByNameandAge(String name, int age1, int age2) {
    
        List<Customer> filteredList = filterByAge(age1, age2);

        return filteredList.stream()
                .filter(customer -> customer.getName().equals(name))
                .toList();
        
    }

}
