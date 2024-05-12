package com.ranga.minilibrary.books.controller;

import com.ranga.minilibrary.books.dto.BooksDto;
import com.ranga.minilibrary.books.dto.IssuedBooksDto;
import com.ranga.minilibrary.books.dto.ResponseDto;
import com.ranga.minilibrary.books.entity.IssuedBooksEntity;
import com.ranga.minilibrary.books.feign.BooksService;
import com.ranga.minilibrary.books.mapper.IssuedBooksMapper;
import com.ranga.minilibrary.books.service.BooksIssuedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@Tag(
        name = "Book Issue Return Controller",
        description = "Book Issue Return Controller to manage the books issued and returned"
)
public class BookIssueReturnController {
    @Autowired
    BooksIssuedService booksIssuedService;

    @Autowired
    BooksService booksService;

    @PostMapping("/issue/{bookId}/{userName}")
    @Operation(
            summary = "Issue Book",
            description = "Issue a book to a user"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Book Issued Successfully",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> issueBook(
            @PathVariable("bookId") Integer bookId,
            @PathVariable("userName") String userName
    ) {
        IssuedBooksEntity entity = booksIssuedService.issueBook(bookId, userName);
        final IssuedBooksDto responseData = IssuedBooksMapper.toDto(entity);
        final ResponseEntity<ResponseDto<BooksDto>> booksResponse = booksService.getBookById(bookId);
        if (booksResponse.getStatusCode().is2xxSuccessful()) {
            responseData.setBook(booksResponse.getBody().getData());
        }
        ResponseDto responseDto = ResponseDto.builder()
                .data(responseData)
                .message("Book Issued Successfully")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/return/{bookId}/{userName}")
    @Operation(
            summary = "Return Book",
            description = "Return a book from a user"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Book Returned Successfully",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> returnBook(
            @PathVariable("bookId") Integer bookId,
            @PathVariable("userName") String userName
    ) {
        IssuedBooksEntity entity = booksIssuedService.returnBook(bookId, userName);
        final IssuedBooksDto responseData = IssuedBooksMapper.toDto(entity);
        final ResponseEntity<ResponseDto<BooksDto>> booksResponse = booksService.getBookById(bookId);
        if (booksResponse.getStatusCode().is2xxSuccessful()) {
            responseData.setBook(booksResponse.getBody().getData());
        }
        ResponseDto responseDto = ResponseDto.builder()
                .data(responseData)
                .message("Book Returned Successfully")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(responseDto);
    }
}
