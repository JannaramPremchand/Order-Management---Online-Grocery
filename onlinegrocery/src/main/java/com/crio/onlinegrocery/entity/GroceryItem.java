package com.crio.onlinegrocery.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private double price;
    private int quantity;
}
