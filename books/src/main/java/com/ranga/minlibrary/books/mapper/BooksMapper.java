package com.ranga.minlibrary.books.mapper;

public class BooksMapper {
    public static com.ranga.minlibrary.books.dto.BooksDto toDto(com.ranga.minlibrary.books.entity.BooksEntity entity) {
        return new com.ranga.minlibrary.books.dto.BooksDto(entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getPublishedYear());
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
