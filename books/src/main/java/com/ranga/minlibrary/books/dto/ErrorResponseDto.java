package com.ranga.minlibrary.books.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    private String apiPath;
    private Object errorMessage;
    private HttpStatus errorCode;
    private LocalDateTime timestamp;
}
