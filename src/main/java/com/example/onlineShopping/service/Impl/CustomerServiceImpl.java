package com.example.onlineShopping.service.Impl;

import com.example.onlineShopping.dto.CustomerDto;
import com.example.onlineShopping.entity.Customer;
import com.example.onlineShopping.exception.CustomerNotFound;
import com.example.onlineShopping.mapstruct.MapStructMapper;
import com.example.onlineShopping.repository.CustomerRepository;
import com.example.onlineShopping.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final MapStructMapper mapStructMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, MapStructMapper mapStructMapper) {
        this.customerRepository = customerRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = mapStructMapper.customerDtoToCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("Customer saved successfully");
        CustomerDto savedCustomerDto = mapStructMapper.customerToCustomerDto(savedCustomer);
        return savedCustomerDto;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = customerList.stream().map(mapStructMapper::customerToCustomerDto).collect(Collectors.toList());
        return customerDtoList;
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer == null){
            throw new CustomerNotFound("Customer Not Found");
        }
        customerRepository.deleteById(customerId);
    }
}
