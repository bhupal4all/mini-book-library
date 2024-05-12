package com.ranga.minilibrary.books.mapper;

import com.ranga.minilibrary.books.dto.InventoryDto;
import com.ranga.minilibrary.books.entity.InventoryEntity;

public class InventoryMapper {
    public static InventoryDto toDto(InventoryEntity entity) {
        final InventoryDto inventoryDto = InventoryDto.builder()
                .id(entity.getId())
                .bookId(entity.getBookId())
                .onHandQuantity(entity.getOnHandQuantity())
                .allocatedQuantity(entity.getAllocatedQuantity())
                .build();
        inventoryDto.setCreatedBy(entity.getCreatedBy());
        inventoryDto.setCreatedAt(entity.getCreatedAt());
        inventoryDto.setUpdatedBy(entity.getUpdatedBy());
        inventoryDto.setUpdatedAt(entity.getUpdatedAt());
        return inventoryDto;
    }

    public static InventoryEntity toEntity(InventoryDto dto) {
        InventoryEntity entity = new InventoryEntity();
        entity.setId(dto.getId());
        entity.setBookId(dto.getBookId());
        entity.setOnHandQuantity(dto.getOnHandQuantity());
        entity.setAllocatedQuantity(dto.getAllocatedQuantity());
        return entity;
//        return InventoryEntity.builder()
//                .id(dto.getId())
//                .bookId(dto.getBookId())
//                .onHandQuantity(dto.getOnHandQuantity())
//                .allocatedQuantity(dto.getAllocatedQuantity())
//                .build();
    }
}
