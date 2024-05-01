package com.ranga.minlibrary.inventory.service;

import com.ranga.minlibrary.inventory.entity.IssuedBooksEntity;
import com.ranga.minlibrary.inventory.exceptions.BookIsNotIssuedException;
import com.ranga.minlibrary.inventory.exceptions.BookReturnedException;
import com.ranga.minlibrary.inventory.repository.IssuedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BooksIssuedService {
    @Autowired
    private IssuedBooksRepository issuedBooksRepository;

    public List<IssuedBooksEntity> getAllBooksIssued() {
        return this.issuedBooksRepository.findAll();
    }

    public IssuedBooksEntity addBooksIssued(final IssuedBooksEntity issuedBooksEntity) {
        return this.issuedBooksRepository.save(issuedBooksEntity);
    }

    public void deleteBooksIssued(final Integer id) {
        this.issuedBooksRepository.deleteById(id);
    }

    public IssuedBooksEntity issueBook(final Integer bookId, final String userName) {
        IssuedBooksEntity issuedBooksEntity = new IssuedBooksEntity();
        issuedBooksEntity.setBookId(bookId);
        issuedBooksEntity.setIssuedTo(userName);
        issuedBooksEntity.setIssuedAt(LocalDateTime.now());
        issuedBooksEntity.setDueAt(LocalDateTime.now().plusDays(7));
        return this.issuedBooksRepository.save(issuedBooksEntity);
    }

    public IssuedBooksEntity returnBook(final Integer bookId, final String userName) {
        IssuedBooksEntity issuedBooksEntity = this.issuedBooksRepository.findByBookIdAndIssuedTo(bookId, userName)
                .orElseThrow(() -> new BookIsNotIssuedException());
        if (issuedBooksEntity.getReturnedAt() != null) {
            throw new BookReturnedException();
        }
        issuedBooksEntity.setReturnedAt(LocalDateTime.now());
        return this.issuedBooksRepository.save(issuedBooksEntity);
    }
}
