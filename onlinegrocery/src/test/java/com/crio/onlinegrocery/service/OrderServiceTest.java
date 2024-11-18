package com.crio.onlinegrocery.service;

import com.crio.onlinegrocery.entity.Order;
import com.crio.onlinegrocery.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    public OrderServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetOrderById() {
        Order mockOrder = new Order();
        mockOrder.setId(1L);

        when(orderRepository.findById(1L)).thenReturn(Optional.of(mockOrder));

        Order order = orderService.getOrderById(1L);

        assertNotNull(order);
        assertEquals(1L, order.getId());
    }
}
