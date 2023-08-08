package com.example.client.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdNumberValidatorTest {
    private IdNumberValidator idNumberValidator;
    @BeforeEach
    void setUp() {
        idNumberValidator = new IdNumberValidator();
    }
    @Test
    @DisplayName("It should validate id number")
    void itShouldValidateIdNumber() throws ValidationException {
        //Given
        String idNumber = "7208085992081";
        //When
        boolean isValid = idNumberValidator.validateSAID(idNumber);
        //Then
        assertThat(isValid).isTrue();

    }
}
