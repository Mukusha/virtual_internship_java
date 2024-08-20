package org.javaguru.travel.insurance.core;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeService {
    long getDaysBetween(Date date1, Date date2) {
        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return java.time.temporal.ChronoUnit.DAYS.between(localDate1, localDate2);
    }
}
