package com.bridgelabz;

/*******************************************************
 *
 * This class contains all the methods that are required
 * to generate cab invoice.
 *******************************************************/

public class CabInvoiceGenerator
{
    private static final double FARE_PER_KM = 10;
    private static final double FARE_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;

    /**
     * Name : getfare
     *
     * Description : Calculate fare based on distance and time.
     *
     * @param distance
     * @param time
     * @return
     *
     */
    public double getfare(double distance, double time)
    {
        double fare = distance*FARE_PER_KM + time*FARE_PER_MINUTE;
        return Math.max(MINIMUM_FARE, fare);
    }

    public double calculateTotalFare(Ride[] rides)
    {
        double totalFare = 0;
        for (Ride ride : rides)
        {
            totalFare+=getfare(ride.distance, ride.time);
        }
        return totalFare;
    }
}