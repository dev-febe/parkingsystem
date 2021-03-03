package com.parkit.parkingsystem.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBConstantsTest {
    @Test
    public void getNextParking_shouldRetrieveQueryToGetNextParking() {
        assertEquals(
                DBConstants.GET_NEXT_PARKING_SPOT,
                "select min(PARKING_NUMBER) from parking where AVAILABLE = true and TYPE = ?"
        );
    }

    @Test
    public void updateParkingSpot_shouldRetrieveQueryToUpdateParkingSpot() {
        assertEquals(
                DBConstants.UPDATE_PARKING_SPOT,
                "update parking set available = ? where PARKING_NUMBER = ?"
        );
    }

    @Test
    public void getSaveTicket_shouldRetrieveQueryToSaveTicket() {
        assertEquals(
                DBConstants.SAVE_TICKET,
                "insert into ticket(PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME, DISCOUNT) values(?,?,?,?,?,?)"
        );
    }

    @Test
    public void updateTicket_shouldRetrieveQueryToUpdateTicket() {
        assertEquals(DBConstants.UPDATE_TICKET, "update ticket set PRICE=?, IN_TIME=?, OUT_TIME=? where ID=?");
    }

    @Test
    public void getTicket_shouldRetrieveQueryToGetTicket() {
        assertEquals(
                DBConstants.GET_TICKET,
                "select t.PARKING_NUMBER, t.ID, t.PRICE, t.IN_TIME, t.OUT_TIME, p.TYPE, t.DISCOUNT from ticket t,parking p where p.parking_number = t.parking_number and t.VEHICLE_REG_NUMBER=? and (t.OUT_TIME >= NOW() or t.OUT_TIME IS NULL) order by t.ID DESC limit 1"
        );
    }

    @Test
    public void getPreviousTicket_shouldRetrieveQueryToGetTicket() {
        assertEquals(
                DBConstants.GET_PREVIOUS_TICKET,
                "select t.PARKING_NUMBER, t.ID, t.PRICE, t.IN_TIME, t.OUT_TIME, p.TYPE, t.DISCOUNT from ticket t,parking p where p.parking_number = t.parking_number and t.VEHICLE_REG_NUMBER=? order by t.ID DESC limit 1"
        );
    }

    @Test
    public void updateInTimeTicket() {
        assertEquals(
                DBConstants.UPDATE_IN_TIME_TICKET,
                "update ticket set IN_TIME=? where ID=?"
        );
    }
}
