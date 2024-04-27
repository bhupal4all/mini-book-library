package com.ranga.minlibrary.books.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {
    @Column(name = "created_by", nullable = false, updatable = false, insertable = true)
    String createdBy;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = true)
    LocalDateTime createdAt;

    @Column(name = "updated_by", nullable = false, updatable = true, insertable = false)
    String updatedBy;

    @Column(name = "updated_at", nullable = false, updatable = true, insertable = false)
    LocalDateTime updatedAt;
}
