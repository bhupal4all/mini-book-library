package com.ranga.minilibrary.inventory.feign;

import com.ranga.minilibrary.inventory.dto.BooksDto;
import com.ranga.minilibrary.inventory.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "books")
public interface BooksService {
    @GetMapping("/api/v1/books/{id}")
    ResponseEntity<ResponseDto<BooksDto>> getBookById(@PathVariable(name = "id") Integer id);
}
