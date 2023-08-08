package com.example.client.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhysicalAddressValidatorTest {
    private PhysicalAddressValidator physicalAddressValidator;
    @BeforeEach
    void setUp() {
        physicalAddressValidator = new PhysicalAddressValidator();
    }
    @Test
    @DisplayName("It should validate physical address")
    void itShouldValidatePhysicalAddress() {
        //Given
        String physicalAddress = "123, Street";
        //When
        boolean isValid = physicalAddressValidator.test(physicalAddress);
        //Then
        assertThat(isValid).isTrue();

    }
}
