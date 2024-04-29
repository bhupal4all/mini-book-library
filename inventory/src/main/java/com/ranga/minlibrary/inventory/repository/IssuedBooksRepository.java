package com.ranga.minlibrary.inventory.repository;

import com.ranga.minlibrary.inventory.entity.IssuedBooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooksEntity, Integer> {
}
