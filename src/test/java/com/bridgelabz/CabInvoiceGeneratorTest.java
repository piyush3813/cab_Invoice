package com.bridgelabz;

import com.bridgelabz.CabInvoiceGenerator;
import org.junit.Test;
import org.junit.Assert;

/****************************************************
 *
 * This is a test case class.
 * This class holds all the related test cases that,
 * test all the methods od the project.
 * **************************************************/

public class CabInvoiceGeneratorTest
{
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 5.0;
        double time = 2;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time);
        Assert.assertEquals(52, totalfare,0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThanMinimumFare_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        double time = 2;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time);
        Assert.assertEquals(5, totalfare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary()
    {
        CabInvoiceGenerator cabInvoiceGenerator =new CabInvoiceGenerator();
        Ride[] rides = { new Ride(5.0,2),new Ride(0.1,2)};
        InvoiceSummary summary =  cabInvoiceGenerator.calculateTotalFare(1,rides);
        InvoiceSummary  expectedSummary = new InvoiceSummary(1,2,57.0);
        Assert.assertEquals(expectedSummary,summary);
    }

    @Test
    public void givenUserID_ShouldReturnListOfRides()
    {
        CabInvoiceGenerator cabInvoiceGenerator =new CabInvoiceGenerator();
        Ride[] rides = { new Ride(5.0,2),new Ride(0.1,2)};
        cabInvoiceGenerator.calculateTotalFare(1,rides);
        Ride[] expectedRide = cabInvoiceGenerator.rideRepository.get(1);
        Assert.assertEquals(expectedRide.toString(),rides.toString());
    }
}