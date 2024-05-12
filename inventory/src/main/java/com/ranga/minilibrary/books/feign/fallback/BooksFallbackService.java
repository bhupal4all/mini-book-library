package com.ranga.minilibrary.books.feign.fallback;

import com.ranga.minilibrary.books.dto.BooksDto;
import com.ranga.minilibrary.books.dto.ResponseDto;
import com.ranga.minilibrary.books.feign.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BooksFallbackService implements BooksService {

    public BooksFallbackService() {
        log.error("-- FeignBooksFallbackService created");
    }

    @Override
    public ResponseEntity<ResponseDto<BooksDto>> getBookById(final Integer id) {
        log.info("[FALLBACK], Books service is not available");
        ResponseDto<BooksDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
        responseDto.setMessage("Books service is not available");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(responseDto);
    }
}
