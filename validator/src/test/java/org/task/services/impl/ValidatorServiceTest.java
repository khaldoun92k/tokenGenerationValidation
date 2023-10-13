package org.task.services.impl;

import org.junit.jupiter.api.Test;
import org.task.services.ValidatorService;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorServiceTest {
    private final ValidatorService validatorService =new ValidatorServiceImpl();
    @Test
    void testValidateToken() {
        //Valid case
        String valid="3379-5135-6110-8795";
        assert(validatorService.validateToken(valid));
        //Invalid case
        String invalid="3379-5135-6110-8794";
        assertFalse(validatorService.validateToken(invalid));
    }
}