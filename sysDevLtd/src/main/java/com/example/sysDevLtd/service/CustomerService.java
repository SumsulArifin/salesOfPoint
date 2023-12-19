package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.Customer;
import com.example.sysDevLtd.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void customerSave(Customer customer) {

        customerRepository.save(customer);
    }
}
