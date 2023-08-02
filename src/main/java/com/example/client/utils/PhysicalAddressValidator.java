package com.example.client.utils;

import java.util.function.Predicate;

public class PhysicalAddressValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return false;
    }
}
