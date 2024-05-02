package com.ranga.minilibrary.inventory.repository;

import com.ranga.minilibrary.inventory.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
}
