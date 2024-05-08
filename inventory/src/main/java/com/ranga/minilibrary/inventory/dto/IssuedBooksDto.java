package com.ranga.minilibrary.inventory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(
        name = "Issued Books",
        description = "Issued Books Data Transfer Object"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssuedBooksDto {
    Integer id;

    @NotNull(message = "Book Id should not be null")
    @Min(value = 1, message = "Book Id should be positive")
    @Schema(description = "Book Id", example = "1")
    Integer bookId;

    @Size(min = 3, max = 50, message = "Issued To should be between 3 and 50 characters")
    @Schema(description = "Issued To", example = "Ranga")
    String issuedTo;

    @Schema(description = "Issued At", example = "2021-09-01T10:00:00")
    LocalDateTime issuedAt;

    @Schema(description = "Due At", example = "2021-09-15T10:00:00")
    LocalDateTime dueAt;

    @Schema(description = "Returned At", example = "2021-09-15T10:00:00")
    LocalDateTime returnedAt;

    @Schema(description = "Book Details")
    BooksDto book;
}
