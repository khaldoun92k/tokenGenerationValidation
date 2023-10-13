package org.task.services;

import java.util.Set;

public interface GeneratorService {
    /** generate a token matching this format "XXXX-XXXX-XXXX-XXXX" from a set number for integer 0-9 **/
    String generateToken(Set<Integer> digits);
}
