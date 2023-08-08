package com.example.client.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class PhoneNumberValidator implements Predicate<String> {

    public boolean validatePhoneNumber(String phoneNumber) throws ValidationException{
        String rex = "(?:\\+?27|0)\\d{9}";
        if(phoneNumber.matches(rex)){
            return true;
        }
        else {
            throw new ValidationException("Invalid Phone Number.");

        }

    }

    @Override
    public boolean test(String s) {
        return false;
    }
}