package com.daylton.estacionamento.service;

import com.daylton.estacionamento.model.Parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingCheckout {

    public static final int ONE_OUR = 60;
    public static final int TWENTY_FOUR_OUR = 24 * ONE_OUR;
    public static final double ONE_HOUR_VALUE = 5.00;
    public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
    public static final double DAY_VALUE = 20.00;


    public static Double getBill(Parking parking) {
        return getBill(parking.getEntryDate(), parking.getExitDate());
    }

    private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {

        long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);
        Double bill = 0.0;
        if (minutes <= ONE_OUR) {
            return ONE_HOUR_VALUE;
        }
        if (minutes <= TWENTY_FOUR_OUR) {
            bill = ONE_HOUR_VALUE;
            int hours = (int) (minutes / ONE_OUR);
            for (int i = 0; i < hours; i++) {
                bill += ADDITIONAL_PER_HOUR_VALUE;
            }
            return bill;
        }
        int days = (int) (minutes / TWENTY_FOUR_OUR);
        for (int i = 0; i < days; i++) {
            bill += DAY_VALUE;
        }
        return bill;
    }
}
