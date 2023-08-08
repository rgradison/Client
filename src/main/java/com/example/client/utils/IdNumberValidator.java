package com.example.client.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class IdNumberValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return false;
    }

    public static boolean validateSAID(String idNumber) throws ValidationException{
        idNumber = idNumber.trim();

        if (idNumber == null || idNumber.length() != 13) {
            throw  new ValidationException("ID length should be 13 digits");
        }

        // Check if ID number contains only numeric digits
        if (!idNumber.matches("\\d+")) {
            throw  new ValidationException("ID must be  numeric");
        }

        if (!isValidChecksum(idNumber)) {
            throw  new ValidationException();
        }

        return true;
    }
    
     private static boolean isValidChecksum(String idNumber) {

        int nDigits = idNumber.length();
        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--)
        {

            int d = idNumber.charAt(i) - '0';

            if (isSecond == true)
                d = d * 2;

            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

}