package com.crio.onlinegrocery.controller;

import com.crio.onlinegrocery.entity.GroceryItem;
import com.crio.onlinegrocery.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery-items")
public class GroceryItemController {
    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }

    @GetMapping("/{id}")
    public GroceryItem getGroceryItemById(@PathVariable Long id) {
        return groceryItemService.getGroceryItemById(id);
    }

    @PostMapping
    public GroceryItem createGroceryItem(@RequestBody GroceryItem groceryItem) {
        return groceryItemService.createGroceryItem(groceryItem);
    }

    @PutMapping("/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
        return groceryItemService.updateGroceryItem(id, groceryItem);
    }

    @DeleteMapping("/{id}")
    public void deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
    }
}
