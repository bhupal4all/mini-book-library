package com.ranga.minilibrary.books.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Schema(name = "Books Contact Info", description = "Books Contact Information")
@ConfigurationProperties(prefix = "books.contact")
@Data
public class BooksContactInfoDto {
    String message;
    Map<String, String> contactDetails;
    List<String> onCallSupport;
}
