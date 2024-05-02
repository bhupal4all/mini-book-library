package com.ranga.minlibrary.inventory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @GetMapping
    @Operation(
            summary = "Welcome",
            description = "Welcome to Inventory Application"
    )
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Inventory Application");
    }
}
