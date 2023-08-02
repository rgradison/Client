package com.example.client.utils;

import java.util.function.Predicate;

public class LastNameValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return false;
    }
}
