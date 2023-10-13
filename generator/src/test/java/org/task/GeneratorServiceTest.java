package org.task;

import org.junit.jupiter.api.Test;
import org.task.services.GeneratorService;
import org.task.services.Impl.GeneratorServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static java.util.regex.Pattern.matches;

public class GeneratorServiceTest {
    private final GeneratorService generatorService =new GeneratorServiceImpl();
    @Test
    public void testGenerateToken() {
        Set<Integer> digits = new HashSet<>(Arrays.asList(2,4,7,9,0));
        String generated=generatorService.generateToken(digits);
        System.out.println(generated);
        //checking if the generated token matches the regex
        assert(matches("^[24790]{4}-[24790]{4}-[24790]{4}-[24790]{4}$",generated));
    }
}
