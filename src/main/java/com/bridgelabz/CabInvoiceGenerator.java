package com.bridgelabz;

import java.util.HashMap;

/*******************************************************
 *
 * This class contains all the methods that are required
 * to generate cab invoice.
 *******************************************************/

public class CabInvoiceGenerator
{
    public HashMap<Integer,Ride[]> rideRepository = new HashMap<>();
    private static final double FARE_PER_KM_REGULAR = 10;
    private static final double FARE_PER_MINUTE_REGULAR = 1;
    private static final double MINIMUM_FARE_REGULAR = 5;

    private static final double FARE_PER_KM_PREMIUM = 15;
    private static final double FARE_PER_MINUTE_PREMIUM = 2;
    private static final double MINIMUM_FARE_PREMIUM = 20;

    /**
     * Name : getfare
     *
     * Description : Calculate fare based on distance and time.
     *
     * @param distance
     * @param time
     * @return

     */
    public double getfare(double distance, double time,String rideType)
    {
        if (rideType.equals("premium"))
        {
            return Math.max(MINIMUM_FARE_PREMIUM, distance*FARE_PER_KM_PREMIUM + time*FARE_PER_MINUTE_PREMIUM );
        }
        return Math.max(MINIMUM_FARE_REGULAR, distance*FARE_PER_KM_REGULAR + time*FARE_PER_MINUTE_REGULAR);
    }

    /**
     * Name : calculateTotalFare.
     *
     * Description : Calculating total fare based on rides.
     *
     * @param userId
     * @param rides
     * @return
     *
     */
    public InvoiceSummary calculateTotalFare(int userId,Ride[] rides,String rideType)
    {
        double totalFare = 0;
        for (Ride ride : rides)
        {
            totalFare+=getfare(ride.distance, ride.time,rideType);
        }
        rideRepository.put(userId,rides);
        return  new InvoiceSummary(userId,rides.length, totalFare);
    }
}