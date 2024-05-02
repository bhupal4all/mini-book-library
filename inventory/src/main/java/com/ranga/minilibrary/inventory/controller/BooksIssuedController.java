package com.ranga.minilibrary.inventory.controller;

import com.ranga.minilibrary.inventory.dto.ErrorResponseDto;
import com.ranga.minilibrary.inventory.dto.IssuedBooksDto;
import com.ranga.minilibrary.inventory.dto.ResponseDto;
import com.ranga.minilibrary.inventory.entity.IssuedBooksEntity;
import com.ranga.minilibrary.inventory.mapper.IssuedBooksMapper;
import com.ranga.minilibrary.inventory.service.BooksIssuedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/issue")
@Tag(
        name = "Books Issued Controller",
        description = "Books Issued Controller to manage the books issued"
)
public class BooksIssuedController {

    @Autowired
    private BooksIssuedService booksIssuedService;

    @GetMapping
    @Operation(
            summary = "Get Books Issued",
            description = "Get all the books issued"
    )
    public ResponseEntity<ResponseDto> getBooksIssued() {
        final List<IssuedBooksEntity> allBooksIssued = this.booksIssuedService.getAllBooksIssued();
        allBooksIssued.stream().map(IssuedBooksMapper::toDto).collect(Collectors.toList());
        ResponseDto responseDto = ResponseDto.builder()
                .data(allBooksIssued)
                .status(HttpStatus.OK)
                .message("Retried Books Issued")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    @Operation(
            summary = "Add Books Issued",
            description = "Add a new book issued"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Book Issued Successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> addBooksIssued(
            @Valid @RequestBody IssuedBooksDto issuedBooksDto
    ) {
        final IssuedBooksEntity savedEntity = this.booksIssuedService.addBooksIssued(
                IssuedBooksMapper.toEntity(issuedBooksDto)
        );
        ResponseDto responseDto = ResponseDto.builder()
                .data(savedEntity)
                .status(HttpStatus.OK)
                .message("Book Issued Successfully")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Books Issued",
            description = "Update an existing book issued"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Book Issued Updated Successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> updateBooksIssued(
            @PathVariable Integer id,
            @Valid @RequestBody IssuedBooksDto issuedBooksDto
    ) {
        Assert.isTrue(id == issuedBooksDto.getId(), "Id mismatch");
        final IssuedBooksEntity savedEntity = this.booksIssuedService.addBooksIssued(
                IssuedBooksMapper.toEntity(issuedBooksDto)
        );
        ResponseDto responseDto = ResponseDto.builder()
                .data(savedEntity)
                .status(HttpStatus.OK)
                .message("Book Issued Successfully")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Books Issued",
            description = "Delete an existing book issued"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Book Issued Deleted Successfully"
            )
    })
    public ResponseEntity<ResponseDto> deleteBooksIssued(
            @PathVariable Integer id
    ) {
        this.booksIssuedService.deleteBooksIssued(id);
        ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK)
                .message("Book Issued Deleted Successfully")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
