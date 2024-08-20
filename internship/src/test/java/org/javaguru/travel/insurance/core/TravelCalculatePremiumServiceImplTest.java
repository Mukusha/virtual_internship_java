package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {
    private TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();


    @Test
    public void calculatePremiumTest() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Ivan",
                "Ivanov",
                new Date(),
                new Date()
        );

        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
        assertEquals(response.getPersonLastName(), request.getPersonLastName());
        assertEquals(response.getAgreementDateFrom(), request.getAgreementDateFrom());
        assertEquals(response.getAgreementDateTo(), request.getAgreementDateTo());
    }

}