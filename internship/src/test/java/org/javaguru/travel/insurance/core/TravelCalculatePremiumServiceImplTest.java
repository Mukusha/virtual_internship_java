package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {
    private final DateTimeService dateTimeService = new DateTimeService();
    private final TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(dateTimeService);


    @Test
    public void calculatePremiumTestForFirstName() {
        TravelCalculatePremiumRequest request = createRequest();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
    }

    @Test
    public void calculatePremiumTestForLastName() {
        TravelCalculatePremiumRequest request = createRequest();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(response.getPersonLastName(), request.getPersonLastName());
    }

    @Test
    public void calculatePremiumTestForAgreementDateFrom() {
        TravelCalculatePremiumRequest request = createRequest();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(response.getAgreementDateFrom(), request.getAgreementDateFrom());
    }

    @Test
    public void calculatePremiumTestForAgreementDateTo() {
        TravelCalculatePremiumRequest request = createRequest();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(response.getAgreementDateTo(), request.getAgreementDateTo());
    }

    @Test
    public void calculatePremiumTestForAgreementPrice0() {
        TravelCalculatePremiumRequest request = createRequest();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(response.getAgreementPrice(), new BigDecimal(0));
    }

    @Test
    public void calculatePremiumTestForAgreementPrice() {
        TravelCalculatePremiumRequest request = createRequest();
        request.setAgreementDateFrom(new Date(2021, Calendar.DECEMBER, 16));
        request.setAgreementDateTo(new Date(2021, Calendar.DECEMBER, 22));
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(response.getAgreementPrice(), new BigDecimal(6));
    }

    private TravelCalculatePremiumRequest createRequest() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Peterson");
        request.setAgreementDateFrom(new Date());
        request.setAgreementDateTo(new Date());
        return request;
    }

}