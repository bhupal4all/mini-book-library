package com.ranga.minilibrary.books.service;

import com.ranga.minilibrary.books.entity.InventoryEntity;
import com.ranga.minilibrary.books.entity.IssuedBooksEntity;
import com.ranga.minilibrary.books.exceptions.BookIsNotIssuedException;
import com.ranga.minilibrary.books.exceptions.BookReturnedException;
import com.ranga.minilibrary.books.exceptions.InsufficientInventoryException;
import com.ranga.minilibrary.books.repository.IssuedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BooksIssuedService {
    @Autowired
    private IssuedBooksRepository issuedBooksRepository;

    @Autowired
    private InventoryService inventoryService;

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
        final Integer requestedQty = 1;
        final InventoryEntity inventoryForBookId = inventoryService.getInventoryForBookId(bookId);
        if (inventoryForBookId.getOnHandQuantity() - 1 < 0) {
            throw new InsufficientInventoryException();
        }

        inventoryForBookId.setOnHandQuantity(inventoryForBookId.getOnHandQuantity() - requestedQty);
        inventoryForBookId.setAllocatedQuantity(inventoryForBookId.getAllocatedQuantity() + requestedQty);
        inventoryService.saveInventory(inventoryForBookId);

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

        final Integer requestedQty = 1;
        final InventoryEntity inventoryForBookId = inventoryService.getInventoryForBookId(bookId);
        inventoryForBookId.setOnHandQuantity(inventoryForBookId.getOnHandQuantity() + requestedQty);
        inventoryForBookId.setAllocatedQuantity(inventoryForBookId.getAllocatedQuantity() - requestedQty);
        inventoryService.saveInventory(inventoryForBookId);

        issuedBooksEntity.setReturnedAt(LocalDateTime.now());
        return this.issuedBooksRepository.save(issuedBooksEntity);
    }
}
