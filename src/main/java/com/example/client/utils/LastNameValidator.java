package com.example.client.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class LastNameValidator implements Predicate<String> {
    @Override
    public boolean test(String lastName) {
        return false;
    }

    public boolean validateLastName(String lastName) throws ValidationException {
        if ((!lastName.equals("")) && (lastName != null) && (lastName.matches("^[a-zA-Z]{1,20}$"))) {
            return true;
        } else {
            throw new ValidationException("Invalid Last Name.");
        }
    }
}
