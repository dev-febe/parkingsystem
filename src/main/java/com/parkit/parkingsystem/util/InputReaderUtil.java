package com.parkit.parkingsystem.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Utility for console input
 */
public class InputReaderUtil {
    private static final Scanner scan = new Scanner(System.in, "UTF-8");
    private static final Logger logger = LogManager.getLogger(InputReaderUtil.class);

    /**
     * Read the console input
     *
     * @return the given input
     */
    public int readSelection() {
        try {
            return scan.nextInt();
        } catch (Exception e) {
            logger.error("Error while reading user input from Shell", e);
            System.out.println("Error reading input. Please enter valid number for proceeding further");
            return -1;
        }
    }

    /**
     * Read the vehicle registration number
     *
     * @return the registration number of the vehicle
     * @throws Exception
     */
    public String readVehicleRegistrationNumber() throws Exception {
        try {
            String vehicleRegNumber = scan.nextLine();
            if (vehicleRegNumber == null || vehicleRegNumber.trim().length() == 0) {
                throw new IllegalArgumentException("Invalid input provided");
            }
            return vehicleRegNumber;
        } catch (Exception e) {
            logger.error("Error while reading user input from Shell", e);
            System.out.println("Error reading input. Please enter a valid string for vehicle registration number");
            throw e;
        }
    }


}
