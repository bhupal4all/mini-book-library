package com.ranga.minlibrary.inventory.repository;

import com.ranga.minlibrary.inventory.entity.IssuedBooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooksEntity, Integer> {
    Optional<IssuedBooksEntity> findByBookIdAndIssuedTo(Integer bookId, String userName);
}
