package com.parkit.parkingsystem.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FareTest {
    @Test
    public void bikeRatePerHour_shouldBe_1_0() {
        assertEquals(
                Fare.BIKE_RATE_PER_HOUR,
                1.0
        );
    }

    @Test
    public void carRatePerHour_shouldBe_1_5() {
        assertEquals(
                Fare.CAR_RATE_PER_HOUR,
                1.5
        );
    }

    @Test
    public void RateDiscount_shouldBe_0_5() {
        assertEquals(
                Fare.RATE_DISCOUNT,
                0.5
        );
    }
}
