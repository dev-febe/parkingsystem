package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;
import com.parkit.parkingsystem.util.DateUtil;

public class FareCalculatorService {
    public void calculateFare(Ticket ticket) {
        if ((ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime()))) {

            throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString() + " intime " + ticket.getInTime());
        }

        double durationPerHours = DateUtil.getDurationPerHours(
                ticket.getInTime(),
                ticket.getOutTime()
        );

        // Free parking when duration is under 30 minutes
        if (durationPerHours <= 0.5) {
            durationPerHours = 0;
        }

        switch (ticket.getParkingSpot().getParkingType()) {
            case CAR: {
                ticket.setPrice(durationPerHours * Fare.CAR_RATE_PER_HOUR);
                break;
            }
            case BIKE: {
                ticket.setPrice(durationPerHours * Fare.BIKE_RATE_PER_HOUR);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown Parking Type");
        }
    }
}
