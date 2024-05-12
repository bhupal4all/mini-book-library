package com.ranga.minilibrary.books.handler;

import com.ranga.minilibrary.books.dto.ErrorResponseDto;
import com.ranga.minilibrary.books.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class IssueExceptionHandler {

    @ExceptionHandler({
            BookIsNotIssuedException.class,
            BookReturnedException.class,
            BookNotFoundException.class
    })
    public ResponseEntity<ErrorResponseDto> book(RuntimeException ex,
                                                 WebRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                java.time.LocalDateTime.now()
        );
        log.error("Issue exception: {}", errorResponseDto);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
    }

    @ExceptionHandler({
            InventoryNotFoundException.class,
            InsufficientInventoryException.class
    })
    public ResponseEntity<ErrorResponseDto> inventory(RuntimeException ex,
                                                      WebRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                ex.getMessage(),
                HttpStatus.NOT_FOUND,
                java.time.LocalDateTime.now()
        );
        log.error("Issue exception: {}", errorResponseDto);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

}