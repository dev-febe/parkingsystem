package com.parkit.parkingsystem.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class DateUtilTest {
    @Test
    public void convertToLocalDateTime_shouldConvertDateToLocalDateTime() {
        LocalDateTime localDateTime = DateUtil.convertToLocalDateTime(new Date());
        assertNotNull(localDateTime);
    }

    @ParameterizedTest(name = "The duration of {0}h must be {0}h")
    @ValueSource(ints = {1, 2, 42, 1011, 5089})
    public void getDurationPerHours_shouldGetHalfHour(long hour) {
        Date starTDate = new Date();
        starTDate.setTime(System.currentTimeMillis() - hour * 60 * 60 * 1000);
        Date endDate = new Date();
        double duration = DateUtil.getDurationPerHours(starTDate, endDate);
        assertEquals(duration, hour);
    }
}
