package com.example.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/patients")
    public ResponseEntity<String> patientServiceFallback() {
        return ResponseEntity.ok("Service Patient indisponible, veuillez réessayer plus tard.");
    }

    @GetMapping("/praticiens")
    public ResponseEntity<String> praticienServiceFallback() {
        return ResponseEntity.ok("Service Praticien indisponible, veuillez réessayer plus tard.");
    }
}
