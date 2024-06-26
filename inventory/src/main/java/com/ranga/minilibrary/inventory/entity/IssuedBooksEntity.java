package com.ranga.minilibrary.inventory.entity;

import com.ranga.minilibrary.inventory.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "issued_books")
@Data
public class IssuedBooksEntity extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer bookId;

    String issuedTo;

    LocalDateTime issuedAt;

    LocalDateTime dueAt;

    LocalDateTime returnedAt;
}
