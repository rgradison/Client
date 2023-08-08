package com.example.client.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FirstNameValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return false;
    }

    public boolean validateFirstName(String name) throws ValidationException {
        if ((!name.equals("")) && (name != null) && (name.matches("^[a-zA-Z]{1,20}$"))) {
            return true;
        } else {
            throw new ValidationException("Invalid First Name.");
        }

    }
}