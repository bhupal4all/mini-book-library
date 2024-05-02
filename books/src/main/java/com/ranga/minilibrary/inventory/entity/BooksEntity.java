package com.ranga.minilibrary.inventory.entity;

import com.ranga.minilibrary.inventory.dto.BaseEntity;
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
