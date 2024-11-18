package com.crio.onlinegrocery.controller;

import com.crio.onlinegrocery.entity.Customer;
import com.crio.onlinegrocery.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    private MockMvc mockMvc;

    public CustomerControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void testGetAllCustomers() throws Exception {
        when(customerService.getAllCustomers()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void testCreateCustomer() throws Exception {
        Customer mockCustomer = new Customer();
        mockCustomer.setId(1L);
        mockCustomer.setName("John Doe");

        when(customerService.createCustomer(any(Customer.class))).thenReturn(mockCustomer);

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\",\"email\":\"john@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }
}
