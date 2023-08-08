package com.example.client.utils;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PhoneNumberValidatorTest {
    private PhoneNumberValidator phoneNumberValidator;
    @BeforeEach
    void setUp() {        
        phoneNumberValidator = new PhoneNumberValidator();
    }
    @Test
    @DisplayName("It should validate phone number")
    void itShouldValidatePhoneNumber() throws ValidationException {
        //Given
        String phoneNumber = "+27824844002";
        //When
        boolean isValid = phoneNumberValidator.validatePhoneNumber(phoneNumber);
        //Then
        assertThat(isValid).isTrue();

    }

}
