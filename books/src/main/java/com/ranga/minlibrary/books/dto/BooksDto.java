package com.ranga.minlibrary.books.dto;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
public class BooksDto extends BaseDto {
    Integer id;

    String title;

    String author;

    int publishedYear;

    public BooksDto(Integer id, String title, String author, int publishedYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }
}
