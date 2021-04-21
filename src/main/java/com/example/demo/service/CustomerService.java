package com.example.demo.service;

import com.example.demo.model.Customer;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CustomerService {

    /**
     * Method to process a list of Customer objects, perform some actions on them
     * and return a multi-value Flux<Customer>
     * @param customers
     * @return
     */
    Flux<Customer> processCustomerDataFromCustomerList(List<Customer> customers);
}
