package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = {"/getByDueTimeAsc"})
    @ResponseStatus(HttpStatus.OK)
    public Flux<Customer> postAndReadCustomers(@RequestBody List<Customer> customers) {
        return customerService.processCustomerDataFromCustomerList(customers);
    }
}
