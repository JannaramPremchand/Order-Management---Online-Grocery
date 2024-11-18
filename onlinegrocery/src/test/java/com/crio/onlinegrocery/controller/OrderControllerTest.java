package com.crio.onlinegrocery.controller;

import com.crio.onlinegrocery.entity.Order;
import com.crio.onlinegrocery.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    private MockMvc mockMvc;

    public OrderControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void testGetAllOrders() throws Exception {
        when(orderService.getAllOrders()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void testGetOrderById() throws Exception {
        Order mockOrder = new Order();
        mockOrder.setId(1L);
        mockOrder.setOrderDate(LocalDate.of(2024, 11, 18));
        mockOrder.setTotalPrice(150.75);

        when(orderService.getOrderById(1L)).thenReturn(mockOrder);

        mockMvc.perform(get("/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.totalPrice").value(150.75));
    }

    @Test
    void testCreateOrder() throws Exception {
        Order mockOrder = new Order();
        mockOrder.setId(1L);
        mockOrder.setOrderDate(LocalDate.of(2024, 11, 18));
        mockOrder.setTotalPrice(150.75);

        when(orderService.createOrder(any(Order.class))).thenReturn(mockOrder);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderDate\":\"2024-11-18\",\"totalPrice\":150.75}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.totalPrice").value(150.75));
    }

    @Test
    void testUpdateOrder() throws Exception {
        Order updatedOrder = new Order();
        updatedOrder.setId(1L);
        updatedOrder.setOrderDate(LocalDate.of(2024, 11, 19));
        updatedOrder.setTotalPrice(175.50);

        when(orderService.updateOrder(eq(1L), any(Order.class))).thenReturn(updatedOrder);

        mockMvc.perform(put("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderDate\":\"2024-11-19\",\"totalPrice\":175.50}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderDate").value("2024-11-19"))
                .andExpect(jsonPath("$.totalPrice").value(175.50));
    }

    @Test
    void testDeleteOrder() throws Exception {
        doNothing().when(orderService).deleteOrder(1L);

        mockMvc.perform(delete("/orders/1"))
                .andExpect(status().isOk());
    }
}
