package com.ranga.minlibrary.inventory.repository;

import com.ranga.minlibrary.inventory.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {
}
