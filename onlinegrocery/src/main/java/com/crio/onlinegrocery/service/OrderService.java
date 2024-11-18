package com.crio.onlinegrocery.service;

import com.crio.onlinegrocery.entity.Order;
import com.crio.onlinegrocery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order existingOrder = getOrderById(id);
        existingOrder.setCustomer(updatedOrder.getCustomer());
        existingOrder.setItems(updatedOrder.getItems());
        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
