package com.ranga.minlibrary.books.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "Error Response",
        description = "Error Response object for all API calls"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    @Schema(description = "API Path that caused the error")
    private String apiPath;
    @Schema(description = "Error message or error object")
    private Object errorMessage;
    @Schema(description = "Error code or status")
    private HttpStatus errorCode;
    @Schema(description = "Error timestamp or time of error")
    private LocalDateTime timestamp;
}
