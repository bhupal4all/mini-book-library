package com.ranga.minilibrary.books.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(
        name = "Books",
        description = "Books Data Transfer Object"
)
@NoArgsConstructor
@AllArgsConstructor
public class BooksDto extends BaseDto {
    Integer id;

    @Schema(
            description = "Title of the book",
            example = "Java Programming"
    )
    @Size(min = 3, max = 50, message = "Title should have at least 3 characters and at most 50 characters")
    String title;

    @Schema(
            description = "Author of the book",
            example = "Ranga Bhupal"
    )
    @Size(min = 3, max = 50, message = "Author should have at least 3 characters and at most 50 characters")
    String author;

    @Schema(
            description = "Published year of the book",
            example = "2021"
    )
    @Min(value = 1900, message = "Published year should be greater than 1900")
    int publishedYear;

    @Schema(
            description = "Inventory Details"
    )
    InventoryDto inventory;
}