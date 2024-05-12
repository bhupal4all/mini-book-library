package com.ranga.minilibrary.books.entity;

import com.ranga.minilibrary.books.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "books")
@Setter
@Getter
@ToString(callSuper = true)
public class BooksEntity extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    String author;

    int publishedYear;
}