package com.ranga.minlibrary.books.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "Generic Response",
        description = "Generic Response object for all API calls"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {
    @Schema(description = "Response data")
    private Object data;
    @Schema(description = "Response message")
    private String message;
    @Schema(description = "Response status")
    private HttpStatus status;
    @Schema(description = "Response timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();
}
