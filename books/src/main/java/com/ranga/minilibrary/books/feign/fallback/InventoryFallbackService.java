package com.ranga.minilibrary.books.feign.fallback;

import com.ranga.minilibrary.books.dto.InventoryDto;
import com.ranga.minilibrary.books.dto.ResponseDto;
import com.ranga.minilibrary.books.feign.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryFallbackService implements InventoryService {

    public InventoryFallbackService() {
        log.error("-- InventoryServiceFallbackService is created --");
    }

    @Override
    public ResponseEntity<ResponseDto<InventoryDto>> getInventoryForBookId(Integer bookId) {
        log.info("[FALLBACK], Inventory service is not available");
        ResponseDto<InventoryDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
        responseDto.setMessage("Inventory service is not available");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(responseDto);
    }
}