package com.ranga.minilibrary.inventory.mapper;

import com.ranga.minilibrary.inventory.dto.InventoryDto;
import com.ranga.minilibrary.inventory.entity.InventoryEntity;

public class InventoryMapper {
    public static InventoryDto toDto(InventoryEntity entity) {
        return InventoryDto.builder()
                .id(entity.getId())
                .bookId(entity.getBookId())
                .onHandQuantity(entity.getOnHandQuantity())
                .allocatedQuantity(entity.getAllocatedQuantity())
                .build();
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
