package com.ranga.minilibrary.inventory.controller;

import com.ranga.minilibrary.inventory.dto.BooksContactInfoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
@Tag(
        name = "Welcome Controller",
        description = "Welcome Controller to welcome the users"
)
public class WelcomeController {

    @Value("${spring.application.version:0.0.0}")
    String version;

    @Autowired
    Environment environment;

    @Autowired
    BooksContactInfoDto booksContactInfoDto;

    @GetMapping
    @Operation(
            summary = "Welcome",
            description = "Welcome to Books Application"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Welcome to Books Application"
    )
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Books Application");
    }

    @GetMapping("/version")
    @Operation(
            summary = "Version",
            description = "Version of the Books Application"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Version of the Books Application"
    )
    public ResponseEntity<String> version() {
        return ResponseEntity.ok("Version: " + version);
    }

    @GetMapping("/java-version")
    @Operation(
            summary = "Java Version",
            description = "Java Version of the Books Application"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Java Version of the Books Application"
    )
    public ResponseEntity<String> javaVersion() {
        return ResponseEntity.ok("Java Home: " + environment.getProperty("JAVA_HOME"));
    }

    @GetMapping("/contact")
    @Operation(
            summary = "Contact",
            description = "Contact Information of the Books Application"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Contact Information of the Books Application"
    )
    public ResponseEntity<BooksContactInfoDto> contact() {
        return ResponseEntity.ok(booksContactInfoDto);
    }
}
