package com.example.onlineShopping.service;

import com.example.onlineShopping.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    public CustomerDto saveCustomer(CustomerDto customerDto);

    public List<CustomerDto> getAllCustomers();

    public void deleteCustomer(int customerId);

}
