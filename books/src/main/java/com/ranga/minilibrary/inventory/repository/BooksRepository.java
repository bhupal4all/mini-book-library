package com.ranga.minilibrary.inventory.repository;

import com.ranga.minilibrary.inventory.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {
}
