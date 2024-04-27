package com.ranga.minlibrary.books.service;

import com.ranga.minlibrary.books.entity.BooksEntity;
import com.ranga.minlibrary.books.exceptions.BookNotFoundException;
import com.ranga.minlibrary.books.repository.BooksRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    public List<BooksEntity> getBooks() {
        final List<BooksEntity> books = booksRepository.findAll();
        log.info("Books: {}", books);
        return books;
    }

    public BooksEntity getBookById(Integer id) {
        final BooksEntity book = booksRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        log.info("Book: {}", book);
        return book;
    }


    public BooksEntity addBook(final BooksEntity entity) {
        return booksRepository.save(entity);
    }

    public BooksEntity updateBook(final Integer id, final BooksEntity entity) {
        final BooksEntity book = booksRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        book.setTitle(entity.getTitle());
        book.setAuthor(entity.getAuthor());
        book.setPublishedYear(entity.getPublishedYear());
        return booksRepository.save(book);
    }

    public void deleteBook(final Integer id) {
        booksRepository.deleteById(id);
    }
}
