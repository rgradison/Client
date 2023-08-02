package com.example.client.utils;

import java.util.function.Predicate;

public class IdNumberValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return false;
    }

    @Override
    public Predicate<String> and(Predicate<? super String> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<String> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<String> or(Predicate<? super String> other) {
        return Predicate.super.or(other);
    }

}
