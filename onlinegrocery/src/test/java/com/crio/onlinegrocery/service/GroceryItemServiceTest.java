package com.crio.onlinegrocery.service;

import com.crio.onlinegrocery.entity.GroceryItem;
import com.crio.onlinegrocery.repository.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroceryItemServiceTest {

    @InjectMocks
    private GroceryItemService groceryItemService;

    @Mock
    private GroceryItemRepository groceryItemRepository;

    public GroceryItemServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetGroceryItemById() {
        GroceryItem mockItem = new GroceryItem();
        mockItem.setId(1L);
        mockItem.setName("Apple");

        when(groceryItemRepository.findById(1L)).thenReturn(Optional.of(mockItem));

        GroceryItem item = groceryItemService.getGroceryItemById(1L);

        assertNotNull(item);
        assertEquals("Apple", item.getName());
    }
}
