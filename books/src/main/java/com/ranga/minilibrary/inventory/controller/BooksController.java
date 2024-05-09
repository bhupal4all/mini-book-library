package com.ranga.minilibrary.inventory.controller;

import com.ranga.minilibrary.inventory.dto.BooksDto;
import com.ranga.minilibrary.inventory.dto.ErrorResponseDto;
import com.ranga.minilibrary.inventory.dto.InventoryDto;
import com.ranga.minilibrary.inventory.dto.ResponseDto;
import com.ranga.minilibrary.inventory.entity.BooksEntity;
import com.ranga.minilibrary.inventory.feign.InventoryService;
import com.ranga.minilibrary.inventory.mapper.BooksMapper;
import com.ranga.minilibrary.inventory.service.BooksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Books Controller",
        description = "Books Controller to manage the books"
)
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private InventoryService inventoryService;

    @Operation(
            summary = "Get Books",
            description = "Get all the books"
    )
    @GetMapping
    public ResponseEntity<ResponseDto> getBooks() {
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

    @Operation(
            summary = "Get Book by Id",
            description = "Get the book by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getBookById(@PathVariable(name = "id") Integer id) {
        final BooksDto dto = BooksMapper.toDto(booksService.getBookById(id));

        final ResponseEntity<ResponseDto<InventoryDto>> inventoryForBookId = this.inventoryService.getInventoryForBookId(id);
        if (inventoryForBookId.getStatusCode().is2xxSuccessful()) {
            dto.setInventory(inventoryForBookId.getBody().getData());
        }

        ResponseDto responseDto = ResponseDto.builder()
                .data(dto)
                .message("Book retrieved successfully")
                .status(HttpStatus.OK)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @Operation(
            summary = "Add Book",
            description = "Add a new book"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> addBook(@Valid @RequestBody BooksDto booksDto) {
        final BooksDto dto = BooksMapper.toDto(booksService.addBook(BooksMapper.toEntity(booksDto)));
        ResponseDto responseDto = ResponseDto.builder()
                .data(dto)
                .message("Book added successfully")
                .status(HttpStatus.CREATED)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @Operation(
            summary = "Update Book By Id",
            description = "Update the book Id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book updated successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> updateBook(@Min(value = 1) @PathVariable(name = "id") Integer id, @Valid @RequestBody BooksDto booksDto) {
        final BooksDto dto = BooksMapper.toDto(booksService.updateBook(id, BooksMapper.toEntity(booksDto)));
        ResponseDto responseDto = ResponseDto.builder()
                .data(dto)
                .message("Book updated successfully")
                .status(HttpStatus.OK)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @Operation(
            summary = "Delete Book By Id",
            description = "Delete the book by Id"
    )
    @ApiResponse(responseCode = "200", description = "Book deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteBook(@Min(value = 1) @PathVariable(name = "id") Integer id) {
        booksService.deleteBook(id);
        ResponseDto responseDto = ResponseDto.builder()
                .message("Book deleted successfully")
                .status(HttpStatus.OK)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(responseDto);
    }
}
