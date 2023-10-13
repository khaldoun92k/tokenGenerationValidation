package org.task.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.task.services.GeneratorService;

import java.util.HashSet;

@RestController
public class GeneratorController {
    private final GeneratorService generatorService;
    public GeneratorController (GeneratorService generatorService){
        this.generatorService = generatorService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/generate")
    public ResponseEntity<?> generateToken(@RequestBody HashSet<Integer> digits)
    {
        return ResponseEntity.ok().body(generatorService.generateToken(digits));
    }
}
