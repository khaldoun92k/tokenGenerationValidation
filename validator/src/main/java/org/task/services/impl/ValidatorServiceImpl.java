package org.task.services.impl;

import org.springframework.stereotype.Service;
import org.task.services.ValidatorService;
@Service
public class ValidatorServiceImpl implements ValidatorService {
    @Override
    public Boolean validateToken(String token) {
        //remove separator from token
        String number = token.replace("-", "");
        //Luhn Algorithm
        int sum=0;
        boolean alternate=true;
        for (int i = 0;i<number.length();i++)
        {
            int digit=Character.getNumericValue(number.charAt(i));
            if (alternate){
                digit*=2;
                if (digit>9)
                    digit -= 9;
            }
            sum += digit;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}
