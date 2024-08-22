package org.javaguru.travel.insurance.core;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class DateTimeService {
    long getDaysBetween(Date date1, Date date2) {
        if (date1.equals(date2)) return 0L;
        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return java.time.temporal.ChronoUnit.DAYS.between(localDate1, localDate2);
    }
}
