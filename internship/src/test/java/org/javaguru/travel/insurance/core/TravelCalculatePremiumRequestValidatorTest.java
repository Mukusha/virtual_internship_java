package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TravelCalculatePremiumRequestValidatorTest {
    private TravelCalculatePremiumRequestValidator requestValidator = new TravelCalculatePremiumRequestValidator();

    @Test
    public void validatePersonFirstNameIsNull() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn(null);
        when(request.getPersonLastName()).thenReturn("PersonLastName");
        List<ValidationError> errors = requestValidator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.getFirst().getField(), "personFirstName");
        assertEquals(errors.getFirst().getMessage(), "Must not be empty!");
    }

    @Test
    public void validatePersonFirstNameIsEmpty() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("");
        when(request.getPersonLastName()).thenReturn("PersonLastName");
        List<ValidationError> errors = requestValidator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.getFirst().getField(), "personFirstName");
        assertEquals(errors.getFirst().getMessage(), "Must not be empty!");
    }

    @Test
    public void validatePersonNameIsPresent() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("PersonFirstName");
        when(request.getPersonLastName()).thenReturn("PersonLastName");
        List<ValidationError> errors = requestValidator.validate(request);

        assertTrue(errors.isEmpty());
    }

    @Test
    public void validatePersonLastNameIsNull() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("PersonFirstName");
        when(request.getPersonLastName()).thenReturn(null);
        List<ValidationError> errors = requestValidator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.getFirst().getField(), "personLastName");
        assertEquals(errors.getFirst().getMessage(), "Must not be empty!");
    }

    @Test
    public void validatePersonLastNameIsEmpty() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn("PersonFirstName");
        when(request.getPersonLastName()).thenReturn("");
        List<ValidationError> errors = requestValidator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.getFirst().getField(), "personLastName");
        assertEquals(errors.getFirst().getMessage(), "Must not be empty!");
    }

    @Test
    public void validatePersonNameIsError() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getPersonFirstName()).thenReturn(null);
        when(request.getPersonLastName()).thenReturn("");
        List<ValidationError> errors = requestValidator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 2);
        assertEquals(errors.getFirst().getField(), "personFirstName");
        assertEquals(errors.getFirst().getMessage(), "Must not be empty!");
        assertEquals(errors.getLast().getField(), "personLastName");
        assertEquals(errors.getLast().getMessage(), "Must not be empty!");
    }
}
