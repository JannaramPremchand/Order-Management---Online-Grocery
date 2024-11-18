package com.crio.onlinegrocery.service;

import com.crio.onlinegrocery.entity.Customer;
import com.crio.onlinegrocery.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    public CustomerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCustomerById() {
        Customer mockCustomer = new Customer();
        mockCustomer.setId(1L);
        mockCustomer.setName("John Doe");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(mockCustomer));

        Customer customer = customerService.getCustomerById(1L);

        assertNotNull(customer);
        assertEquals("John Doe", customer.getName());
    }

    @Test
    void testCreateCustomer() {
        Customer customerToSave = new Customer();
        customerToSave.setName("Jane Doe");

        when(customerRepository.save(customerToSave)).thenReturn(customerToSave);

        Customer savedCustomer = customerService.createCustomer(customerToSave);

        assertNotNull(savedCustomer);
        assertEquals("Jane Doe", savedCustomer.getName());
    }
}
