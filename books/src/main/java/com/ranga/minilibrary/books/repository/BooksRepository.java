package com.ranga.minilibrary.books.repository;

import com.ranga.minilibrary.books.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {
}
