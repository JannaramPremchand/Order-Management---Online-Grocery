package com.crio.onlinegrocery.controller;

import com.crio.onlinegrocery.service.GroceryItemService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class GroceryItemControllerTest {

    @InjectMocks
    private GroceryItemController groceryItemController;

    @Mock
    private GroceryItemService groceryItemService;

    private MockMvc mockMvc;

    public GroceryItemControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(groceryItemController).build();
    }

    @Test
    void testGetAllGroceryItems() throws Exception {
        when(groceryItemService.getAllGroceryItems()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/grocery-items"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}
