package com.ranga.minlibrary.books.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDto {
    @Schema(hidden = true)
    String createdBy;
    @Schema(hidden = true)
    LocalDateTime createdAt;
    @Schema(hidden = true)
    String updatedBy;
    @Schema(hidden = true)
    LocalDateTime updatedAt;
}
