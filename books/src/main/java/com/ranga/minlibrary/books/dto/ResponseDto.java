package com.ranga.minlibrary.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {
    private Object data;
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp = LocalDateTime.now();
}
