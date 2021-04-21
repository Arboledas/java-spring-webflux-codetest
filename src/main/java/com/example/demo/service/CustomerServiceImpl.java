package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Flux<Customer> processCustomerDataFromCustomerList(List<Customer> customers) {
        return Flux.fromIterable(customers.stream()
                .sorted(Comparator.comparing(Customer::getDuetime))
                .collect(Collectors.toList()));
    }

}