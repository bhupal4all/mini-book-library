package com.ranga.minilibrary.inventory.service;

import com.ranga.minilibrary.inventory.entity.InventoryEntity;
import com.ranga.minilibrary.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryEntity> getInventories() {
        return this.inventoryRepository.findAll();
    }

    public InventoryEntity saveInventory(final InventoryEntity entity) {
        return this.inventoryRepository.save(entity);
    }

    public void deleteInventory(final Integer id) {
        this.inventoryRepository.deleteById(id);
    }
}
