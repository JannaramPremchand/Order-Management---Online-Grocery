package com.crio.onlinegrocery.repository;

import com.crio.onlinegrocery.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}
