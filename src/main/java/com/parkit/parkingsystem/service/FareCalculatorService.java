package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;
import com.parkit.parkingsystem.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Service that contains all methods for Fare
 */
public class FareCalculatorService {
    private static final Logger logger = LogManager.getLogger(DataBaseConfig.class);

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
                ticket.setPrice(durationPerHours * ticket.getDiscount() * Fare.CAR_RATE_PER_HOUR);
                break;
            }
            case BIKE: {
                ticket.setPrice(durationPerHours * ticket.getDiscount() * Fare.BIKE_RATE_PER_HOUR);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown Parking Type");
        }
    }
}
