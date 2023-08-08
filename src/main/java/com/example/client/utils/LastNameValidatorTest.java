package com.example.client.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LastNameValidatorTest {
    private LastNameValidator lastNameValidator;
    @BeforeEach
    void setUp() {
        lastNameValidator = new LastNameValidator();
    }
    @Test
    @DisplayName("It should validate last name.")
    void itShouldValidateLastName() throws ValidationException {
        //Given
        String lastName = "Gradison";
        //When
        boolean isValid = lastNameValidator.validateLastName(lastName);
        //Then
        assertThat(isValid).isTrue();

    }
}