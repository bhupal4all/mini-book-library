package com.ranga.minilibrary.books.mapper;

import com.ranga.minilibrary.books.dto.BooksDto;
import com.ranga.minilibrary.books.entity.BooksEntity;

public class BooksMapper {
    public static BooksDto toDto(BooksEntity entity) {
        final BooksDto booksDto = new BooksDto(entity.getId(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getPublishedYear(),
                null);
        booksDto.setCreatedBy(entity.getCreatedBy());
        booksDto.setCreatedAt(entity.getCreatedAt());
        booksDto.setUpdatedBy(entity.getUpdatedBy());
        booksDto.setUpdatedAt(entity.getUpdatedAt());
        return booksDto;
    }

    public static BooksEntity toEntity(BooksDto dto) {
        BooksEntity entity = new BooksEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPublishedYear(dto.getPublishedYear());
        return entity;
    }
}
