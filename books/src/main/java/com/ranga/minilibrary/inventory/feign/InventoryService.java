package com.ranga.minilibrary.inventory.feign;

import com.ranga.minilibrary.inventory.dto.InventoryDto;
import com.ranga.minilibrary.inventory.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory")
public interface InventoryService {
    @GetMapping("/api/v1/inventory/book/{bookId}")
    public ResponseEntity<ResponseDto<InventoryDto>> getInventoryForBookId(@PathVariable("bookId") Integer bookId);
}
