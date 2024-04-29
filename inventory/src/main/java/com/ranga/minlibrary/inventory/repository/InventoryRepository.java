package com.ranga.minlibrary.inventory.repository;

import com.ranga.minlibrary.inventory.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
}
