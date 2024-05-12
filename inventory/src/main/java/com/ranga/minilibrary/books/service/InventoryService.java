package com.ranga.minilibrary.books.service;

import com.ranga.minilibrary.books.entity.InventoryEntity;
import com.ranga.minilibrary.books.exceptions.InventoryNotFoundException;
import com.ranga.minilibrary.books.repository.InventoryRepository;
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

    public InventoryEntity getInventoryForBookId(final Integer bookId) {
        return this.inventoryRepository.findByBookId(bookId).orElseThrow(() -> new InventoryNotFoundException());
    }
}
