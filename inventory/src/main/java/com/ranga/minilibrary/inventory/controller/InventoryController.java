package com.ranga.minlibrary.inventory.controller;

import com.ranga.minlibrary.inventory.dto.ErrorResponseDto;
import com.ranga.minlibrary.inventory.dto.InventoryDto;
import com.ranga.minlibrary.inventory.dto.ResponseDto;
import com.ranga.minlibrary.inventory.entity.InventoryEntity;
import com.ranga.minlibrary.inventory.mapper.InventoryMapper;
import com.ranga.minlibrary.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/inventory")
@Tag(
        name = "Inventory Controller",
        description = "Inventory Controller to manage the inventories"
)
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    @Operation(
            summary = "Get Inventories",
            description = "Get all the inventories"
    )
    public ResponseEntity<ResponseDto> getInventories() {
        final List<InventoryEntity> inventories = inventoryService.getInventories();
        final List<InventoryDto> inventoryDtoList = inventories.stream()
                .map(InventoryMapper::toDto).collect(Collectors.toList());
        final ResponseDto responseDto = ResponseDto.builder()
                .data(inventoryDtoList)
                .status(HttpStatus.OK)
                .message("Inventories fetched successfully")
                .timestamp(LocalDateTime.now()).build();
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    @Operation(
            summary = "Add Inventory",
            description = "Add a new inventory"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Inventory updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> addInventory(
            @Valid @RequestBody InventoryDto inventoryDto
    ) {
        final InventoryEntity inventoryEntity = inventoryService.saveInventory(InventoryMapper.toEntity(inventoryDto));
        final ResponseDto responseDto = ResponseDto.builder()
                .data(InventoryMapper.toDto(inventoryEntity))
                .status(HttpStatus.CREATED)
                .message("Inventory added successfully")
                .timestamp(LocalDateTime.now()).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Inventory",
            description = "Update an existing inventory"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Inventory updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> updateInventory(
            @PathVariable("id") Integer id,
            @Valid @RequestBody InventoryDto inventoryDto
    ) {
        final InventoryEntity inventoryEntity = inventoryService.saveInventory(InventoryMapper.toEntity(inventoryDto));
        Assert.isTrue(id == inventoryEntity.getId(), "Id mismatch");
        final ResponseDto responseDto = ResponseDto.builder()
                .data(InventoryMapper.toDto(inventoryEntity))
                .status(HttpStatus.OK)
                .message("Inventory updated successfully")
                .timestamp(LocalDateTime.now()).build();
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Inventory",
            description = "Delete an existing inventory"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Inventory deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request"
            )

    })
    public ResponseEntity<ResponseDto> deleteInventory(
            @PathVariable("id") Integer id
    ) {
        inventoryService.deleteInventory(id);
        final ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK)
                .message("Inventory deleted successfully")
                .timestamp(LocalDateTime.now()).build();
        return ResponseEntity.ok(responseDto);
    }
}
