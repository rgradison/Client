package com.example.client.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class PhysicalAddressValidator implements Predicate<String> {
    @Override
    public boolean test(String address) {
        return true;//address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
    }

}
