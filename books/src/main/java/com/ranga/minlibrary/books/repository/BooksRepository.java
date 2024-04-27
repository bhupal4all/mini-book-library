package com.ranga.minlibrary.books.repository;

import com.ranga.minlibrary.books.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {
}
