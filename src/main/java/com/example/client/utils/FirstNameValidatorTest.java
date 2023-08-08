package com.example.client.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FirstNameValidatorTest {
    private FirstNameValidator firstNameValidator;
    @BeforeEach
    void setUp() {
        firstNameValidator = new FirstNameValidator();
    }
    @Test
    @DisplayName("It should validate first name.")
    void itShouldValidateFirstName() throws ValidationException {
        //Given
        String firstName = "Ralph";
        //When
        boolean isValid = firstNameValidator.validateFirstName(firstName);
        //Then
        assertThat(isValid).isTrue();

    }
}
