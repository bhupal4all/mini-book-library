package com.ranga.minlibrary.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "inventory")
@Data
public class InventoryEntity extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer bookId;

    Long onHandQuantity;

    Long allocatedQuantity;
}
