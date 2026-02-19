package com.ranga.minilibrary.inventory.service;

import com.ranga.minilibrary.inventory.entity.BooksEntity;
import com.ranga.minilibrary.inventory.exceptions.BookNotFoundException;
import com.ranga.minilibrary.inventory.repository.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BooksServiceTest {

    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BooksService booksService;

    private BooksEntity testBook;

    @BeforeEach
    void setUp() {
        testBook = new BooksEntity();
        testBook.setId(1);
        testBook.setTitle("Test Book");
        testBook.setAuthor("Test Author");
        testBook.setPublishedYear(2024);
    }

    @Test
    void testGetBooks() {
        // Arrange
        List<BooksEntity> books = Arrays.asList(testBook);
        when(booksRepository.findAll()).thenReturn(books);

        // Act
        List<BooksEntity> result = booksService.getBooks();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testBook.getTitle(), result.get(0).getTitle());
        verify(booksRepository, times(1)).findAll();
    }

    @Test
    void testGetBookById() {
        // Arrange
        when(booksRepository.findById(1)).thenReturn(Optional.of(testBook));

        // Act
        BooksEntity result = booksService.getBookById(1);

        // Assert
        assertNotNull(result);
        assertEquals(testBook.getId(), result.getId());
        assertEquals(testBook.getTitle(), result.getTitle());
        verify(booksRepository, times(1)).findById(1);
    }

    @Test
    void testGetBookById_NotFound() {
        // Arrange
        when(booksRepository.findById(999)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BookNotFoundException.class, () -> booksService.getBookById(999));
        verify(booksRepository, times(1)).findById(999);
    }

    @Test
    void testAddBook() {
        // Arrange
        when(booksRepository.save(any(BooksEntity.class))).thenReturn(testBook);

        // Act
        BooksEntity result = booksService.addBook(testBook);

        // Assert
        assertNotNull(result);
        assertEquals(testBook.getTitle(), result.getTitle());
        assertEquals(testBook.getAuthor(), result.getAuthor());
        verify(booksRepository, times(1)).save(testBook);
    }

    @Test
    void testUpdateBook() {
        // Arrange
        BooksEntity updatedBook = new BooksEntity();
        updatedBook.setTitle("Updated Title");
        updatedBook.setAuthor("Updated Author");
        updatedBook.setPublishedYear(2025);

        when(booksRepository.findById(1)).thenReturn(Optional.of(testBook));
        when(booksRepository.save(any(BooksEntity.class))).thenReturn(testBook);

        // Act
        BooksEntity result = booksService.updateBook(1, updatedBook);

        // Assert
        assertNotNull(result);
        assertEquals("Updated Title", testBook.getTitle());
        assertEquals("Updated Author", testBook.getAuthor());
        assertEquals(2025, testBook.getPublishedYear());
        verify(booksRepository, times(1)).findById(1);
        verify(booksRepository, times(1)).save(testBook);
    }

    @Test
    void testUpdateBook_NotFound() {
        // Arrange
        BooksEntity updatedBook = new BooksEntity();
        when(booksRepository.findById(999)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BookNotFoundException.class, () -> booksService.updateBook(999, updatedBook));
        verify(booksRepository, times(1)).findById(999);
        verify(booksRepository, never()).save(any());
    }

    @Test
    void testDeleteBook() {
        // Arrange
        Integer bookId = 1;
        doNothing().when(booksRepository).deleteById(bookId);

        // Act
        booksService.deleteBook(bookId);

        // Assert
        verify(booksRepository, times(1)).deleteById(bookId);
    }
}
