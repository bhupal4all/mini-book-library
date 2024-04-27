package com.ranga.minlibrary.books.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDto {
    String createdBy;
    LocalDateTime createdAt;
    String updatedBy;
    LocalDateTime updatedAt;
}
