package com.ranga.minilibrary.inventory.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @ToString
public class BaseEntity {
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false, insertable = true)
    String createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, insertable = true)
    LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = false, updatable = true, insertable = false)
    String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, updatable = true, insertable = false)
    LocalDateTime updatedAt;
}
