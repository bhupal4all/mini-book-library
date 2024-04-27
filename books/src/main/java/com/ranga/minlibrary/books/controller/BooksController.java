package com.ranga.minlibrary.books.controller;

import com.ranga.minlibrary.books.dto.BooksDto;
import com.ranga.minlibrary.books.dto.ResponseDto;
import com.ranga.minlibrary.books.entity.BooksEntity;
import com.ranga.minlibrary.books.mapper.BooksMapper;
import com.ranga.minlibrary.books.service.BooksService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/books", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public ResponseEntity<?> getBooks() {
        final List<BooksEntity> books = booksService.getBooks();
        final Collection<BooksDto> bookDtos = books.stream().map(BooksMapper::toDto)
                .collect(Collectors.toList());
        ResponseDto responseDto = ResponseDto.builder()
                .data(bookDtos)
                .message("Books retrieved successfully")
                .status(HttpStatus.OK)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable(name = "id") Integer id) {
        final BooksDto dto = BooksMapper.toDto(booksService.getBookById(id));
        ResponseDto responseDto = ResponseDto.builder()
                .data(dto)
                .message("Book retrieved successfully")
                .status(HttpStatus.OK)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addBook(@Valid @RequestBody BooksDto booksDto) {
        final BooksDto dto = BooksMapper.toDto(booksService.addBook(BooksMapper.toEntity(booksDto)));
        ResponseDto responseDto = ResponseDto.builder()
                .data(dto)
                .message("Book added successfully")
                .status(HttpStatus.CREATED)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateBook(@Min(value = 1) @PathVariable(name = "id") Integer id, @Valid @RequestBody BooksDto booksDto) {
        final BooksDto dto = BooksMapper.toDto(booksService.updateBook(id, BooksMapper.toEntity(booksDto)));
        ResponseDto responseDto = ResponseDto.builder()
                .data(dto)
                .message("Book updated successfully")
                .status(HttpStatus.OK)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@Min(value = 1) @PathVariable(name = "id") Integer id) {
        booksService.deleteBook(id);
        ResponseDto responseDto = ResponseDto.builder()
                .message("Book deleted successfully")
                .status(HttpStatus.OK)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(responseDto);
    }
}
