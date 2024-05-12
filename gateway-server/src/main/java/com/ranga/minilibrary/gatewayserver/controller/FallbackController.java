package com.ranga.minilibrary.gatewayserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping({"/books"})
    public ResponseEntity<?> booksFallback() {
        final Map<String, String> message = Map.of(
                "message", "Books Service is Not Available, Please contact the support team",
                "status", "503",
                "error", "Service Unavailable"
        );
        return ResponseEntity.status(503).body(message);
    }

    @GetMapping({"/inventory"})
    public ResponseEntity<?> inventoryFallback() {
        final Map<String, String> message = Map.of(
                "message", "Inventory Service is Not Available, Please contact the support team",
                "status", "503",
                "error", "Service Unavailable"
        );
        return ResponseEntity.status(503).body(message);
    }

}
