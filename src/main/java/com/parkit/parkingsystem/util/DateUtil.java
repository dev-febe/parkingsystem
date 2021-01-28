package com.parkit.parkingsystem.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Utility for date management
 */
public class DateUtil {
    /**
     * Convert date in local datetime
     *
     * @param dateToConvert date to convert
     * @return LocalDateTime
     */
    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * Get the delay in hours of 2 dates
     *
     * @param startDate first date
     * @param endDate   last date
     * @return duration per hours
     */
    public static double getDurationPerHours(Date startDate, Date endDate) {
        LocalDateTime LocalStartDateTime = convertToLocalDateTime(startDate);
        LocalDateTime LocalEndDateTime = convertToLocalDateTime(endDate);
        return (double) Duration.between(LocalStartDateTime, LocalEndDateTime).toMinutes() / 60;
    }
}
