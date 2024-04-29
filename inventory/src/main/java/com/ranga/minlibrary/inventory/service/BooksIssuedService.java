package com.ranga.minlibrary.inventory.service;

import com.ranga.minlibrary.inventory.entity.IssuedBooksEntity;
import com.ranga.minlibrary.inventory.repository.IssuedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
