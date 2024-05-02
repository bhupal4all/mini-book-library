package com.ranga.minilibrary.inventory.repository;

import com.ranga.minilibrary.inventory.entity.IssuedBooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooksEntity, Integer> {
    Optional<IssuedBooksEntity> findByBookIdAndIssuedTo(Integer bookId, String userName);
}
