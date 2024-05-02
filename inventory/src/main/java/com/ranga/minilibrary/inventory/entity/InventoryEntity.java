package com.ranga.minilibrary.inventory.entity;

import com.ranga.minilibrary.inventory.dto.BaseEntity;
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
