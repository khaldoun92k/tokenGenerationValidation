package org.task.services.Impl;

import org.springframework.stereotype.Service;
import org.task.services.GeneratorService;

import java.util.Random;
import java.util.Set;
@Service
public class GeneratorServiceImpl implements GeneratorService {
    @Override
    public String generateToken(Set<Integer> digits) {
        Random random = new Random();
        StringBuilder characters=new StringBuilder();
        //putting possible digits in a string
        for (Integer d:digits) {
            characters.append(d);
        }
        int length = 16;
        StringBuilder result = new StringBuilder();
        for ( int i=0; i<length; i++) {
            //generating a random number using math.random()
            int ch = (int)(characters.length() * Math.random());
            //adding Random character one by one at the end of s
            result.append(characters.charAt(ch));
            //adding the separator
            if ((i+1)%4==0 && i!=15)
                result.append('-');
        }
        return result.toString();
    }
}
