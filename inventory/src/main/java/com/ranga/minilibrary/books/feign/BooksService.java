package com.ranga.minilibrary.books.feign;

import com.ranga.minilibrary.books.dto.BooksDto;
import com.ranga.minilibrary.books.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "books")
public interface BooksService {
    @GetMapping("/api/v1/books/{id}")
    ResponseEntity<ResponseDto<BooksDto>> getBookById(@PathVariable(name = "id") Integer id);
}
