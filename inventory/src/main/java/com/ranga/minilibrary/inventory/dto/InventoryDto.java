package com.ranga.minilibrary.inventory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Inventory",
        description = "Inventory Data Transfer Object"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryDto extends BaseDto {
    Integer id;

    @NotNull(message = "Book Id should not be null")
    @Min(value = 1, message = "Book Id should be positive")
    @Schema(description = "Book Id", example = "1")
    Integer bookId;

    @Min(value = 0, message = "OnHand Quantity should be positive")
    @Schema(description = "OnHand Quantity", example = "100")
    Long onHandQuantity;

    @Min(value = 0, message = "Allocated Quantity should be positive")
    @Schema(description = "Allocated Quantity", example = "10")
    Long allocatedQuantity;
}
