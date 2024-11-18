package com.crio.onlinegrocery.service;

import com.crio.onlinegrocery.entity.GroceryItem;
import com.crio.onlinegrocery.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem getGroceryItemById(Long id) {
        return groceryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grocery Item not found"));
    }

    public GroceryItem createGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem updatedItem) {
        GroceryItem existingItem = getGroceryItemById(id);
        existingItem.setName(updatedItem.getName());
        existingItem.setCategory(updatedItem.getCategory());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setQuantity(updatedItem.getQuantity());
        return groceryItemRepository.save(existingItem);
    }

    public void deleteGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
}
