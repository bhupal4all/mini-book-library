package com.ranga.minlibrary.books.mapper;

import com.ranga.minlibrary.books.dto.BooksDto;

public class BooksMapper {
    public static com.ranga.minlibrary.books.dto.BooksDto toDto(com.ranga.minlibrary.books.entity.BooksEntity entity) {
        final BooksDto booksDto = new BooksDto(entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getPublishedYear());
        booksDto.setCreatedBy(entity.getCreatedBy());
        booksDto.setCreatedAt(entity.getCreatedAt());
        booksDto.setUpdatedBy(entity.getUpdatedBy());
        booksDto.setUpdatedAt(entity.getUpdatedAt());
        return booksDto;
    }

    public static com.ranga.minlibrary.books.entity.BooksEntity toEntity(com.ranga.minlibrary.books.dto.BooksDto dto) {
        com.ranga.minlibrary.books.entity.BooksEntity entity = new com.ranga.minlibrary.books.entity.BooksEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPublishedYear(dto.getPublishedYear());
        return entity;
    }
}
