package com.ranga.minilibrary.inventory.service;

import com.ranga.minilibrary.inventory.entity.InventoryEntity;
import com.ranga.minilibrary.inventory.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    private InventoryEntity testInventory;

    @BeforeEach
    void setUp() {
        testInventory = new InventoryEntity();
        testInventory.setId(1);
        testInventory.setBookId(100);
        testInventory.setOnHandQuantity(10L);
        testInventory.setAllocatedQuantity(2L);
    }

    @Test
    void testGetInventories() {
        // Arrange
        List<InventoryEntity> inventories = Arrays.asList(testInventory);
        when(inventoryRepository.findAll()).thenReturn(inventories);

        // Act
        List<InventoryEntity> result = inventoryService.getInventories();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testInventory.getId(), result.get(0).getId());
        verify(inventoryRepository, times(1)).findAll();
    }

    @Test
    void testSaveInventory() {
        // Arrange
        when(inventoryRepository.save(any(InventoryEntity.class))).thenReturn(testInventory);

        // Act
        InventoryEntity result = inventoryService.saveInventory(testInventory);

        // Assert
        assertNotNull(result);
        assertEquals(testInventory.getId(), result.getId());
        assertEquals(testInventory.getBookId(), result.getBookId());
        assertEquals(testInventory.getOnHandQuantity(), result.getOnHandQuantity());
        verify(inventoryRepository, times(1)).save(testInventory);
    }

    @Test
    void testDeleteInventory() {
        // Arrange
        Integer inventoryId = 1;
        doNothing().when(inventoryRepository).deleteById(inventoryId);

        // Act
        inventoryService.deleteInventory(inventoryId);

        // Assert
        verify(inventoryRepository, times(1)).deleteById(inventoryId);
    }
}
