package com.crio.onlinegrocery.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<GroceryItem> items;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private double totalPrice;
}
