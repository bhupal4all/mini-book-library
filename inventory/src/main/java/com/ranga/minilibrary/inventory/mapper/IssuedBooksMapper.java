package com.ranga.minilibrary.inventory.mapper;

import com.ranga.minilibrary.inventory.dto.IssuedBooksDto;
import com.ranga.minilibrary.inventory.entity.IssuedBooksEntity;

public class IssuedBooksMapper {
    public static IssuedBooksDto toDto(IssuedBooksEntity booksIssued) {
        return IssuedBooksDto.builder()
                .id(booksIssued.getId())
                .bookId(booksIssued.getBookId())
                .issuedTo(booksIssued.getIssuedTo())
                .issuedAt(booksIssued.getIssuedAt())
                .dueAt(booksIssued.getDueAt())
                .returnedAt(booksIssued.getReturnedAt())
                .build();
    }

    public static IssuedBooksEntity toEntity(IssuedBooksDto issuedBooksDto) {
        IssuedBooksEntity entity = new IssuedBooksEntity();
        entity.setId(issuedBooksDto.getId());
        entity.setBookId(issuedBooksDto.getBookId());
        entity.setIssuedTo(issuedBooksDto.getIssuedTo());
        entity.setIssuedAt(issuedBooksDto.getIssuedAt());
        entity.setDueAt(issuedBooksDto.getDueAt());
        entity.setReturnedAt(issuedBooksDto.getReturnedAt());
        return entity;
    }
}
