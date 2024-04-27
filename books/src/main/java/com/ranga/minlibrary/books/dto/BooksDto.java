package com.ranga.minlibrary.books.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class BooksDto extends BaseDto {
    Integer id;

    @Size(min = 3, max = 50, message = "Title should have at least 3 characters and at most 50 characters")
    String title;

    @Size(min = 3, max = 50, message = "Author should have at least 3 characters and at most 50 characters")
    String author;

    @Min(value = 1900, message = "Published year should be greater than 1900")
    int publishedYear;

    public BooksDto(Integer id, String title, String author, int publishedYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }
}
