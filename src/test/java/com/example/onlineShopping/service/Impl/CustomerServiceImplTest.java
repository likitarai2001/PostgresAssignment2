package com.example.onlineShopping.service.Impl;

import com.example.onlineShopping.entity.Customer;
import com.example.onlineShopping.repository.CustomerRepository;
import com.example.onlineShopping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceImplTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    public void testDeleteCustomerById(){
        when(customerRepository.findById(1)).thenReturn(Optional.ofNullable(Customer.builder().customerId(1).build()));
//        assertEquals(null);
    }

}