package com.ranga.minilibrary.inventory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Schema(name = "Inventory Contact Info", description = "Inventory Contact Information")
@ConfigurationProperties(prefix = "inventory.contact")
@Data
public class InventoryContactInfoDto {
    String message;
    Map<String, String> contactDetails;
    List<String> onCallSupport;
}
