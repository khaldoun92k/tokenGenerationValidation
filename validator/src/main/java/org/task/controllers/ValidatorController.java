package org.task.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.task.services.ValidatorService;

import java.util.HashSet;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ValidatorController {
    public final ValidatorService validatorService;
    public ValidatorController(ValidatorService validatorService){
        this.validatorService=validatorService;
    }
    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestBody String token)
    {
        boolean isValid = validatorService.validateToken(token);
        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }

}
