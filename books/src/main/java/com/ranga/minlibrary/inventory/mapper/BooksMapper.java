package com.ranga.minlibrary.inventory.mapper;

import com.ranga.minlibrary.inventory.dto.BooksDto;

public class BooksMapper {
    public static com.ranga.minlibrary.inventory.dto.BooksDto toDto(com.ranga.minlibrary.inventory.entity.BooksEntity entity) {
        final BooksDto booksDto = new BooksDto(entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getPublishedYear());
        booksDto.setCreatedBy(entity.getCreatedBy());
        booksDto.setCreatedAt(entity.getCreatedAt());
        booksDto.setUpdatedBy(entity.getUpdatedBy());
        booksDto.setUpdatedAt(entity.getUpdatedAt());
        return booksDto;
    }

    public static com.ranga.minlibrary.inventory.entity.BooksEntity toEntity(com.ranga.minlibrary.inventory.dto.BooksDto dto) {
        com.ranga.minlibrary.inventory.entity.BooksEntity entity = new com.ranga.minlibrary.inventory.entity.BooksEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPublishedYear(dto.getPublishedYear());
        return entity;
    }
}
