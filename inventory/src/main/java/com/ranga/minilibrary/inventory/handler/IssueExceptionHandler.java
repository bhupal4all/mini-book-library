package com.ranga.minilibrary.inventory.handler;

import com.ranga.minilibrary.inventory.dto.ErrorResponseDto;
import com.ranga.minilibrary.inventory.exceptions.BookIsNotIssuedException;
import com.ranga.minilibrary.inventory.exceptions.BookNotFoundException;
import com.ranga.minilibrary.inventory.exceptions.BookReturnedException;
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

    @ExceptionHandler({BookIsNotIssuedException.class, BookReturnedException.class, BookNotFoundException.class})
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



}
