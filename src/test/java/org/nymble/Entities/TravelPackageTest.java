package org.nymble.Entities;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TravelPackageTest {

    @Test
    public void testPrintItinerary() {
        Destination destination1 = new Destination("Beach Resort");
        Activity hiking = new Activity("Hiking", "Enjoy the scenic beauty", 50.0, 10);
        Activity snorkeling = new Activity("Snorkeling", "Explore marine life", 80.0, 8);
        destination1.addActivity(hiking);
        destination1.addActivity(snorkeling);

        TravelPackage travelPackage = new TravelPackage("Summer Vacation", 20);
        travelPackage.addDestination(destination1);

        //process to check for print output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printItinerary();

        System.setOut(System.out);
        String printedValue = outContent.toString();

        assertEquals("Travel Package: Summer Vacation\nDestination: Beach Resort\nActivities:\n - Name: Hiking\n   Description: Enjoy the scenic beauty\n   Cost: ₹50.0\n   Capacity: 10\n - Name: Snorkeling\n   Description: Explore marine life\n   Cost: ₹80.0\n   Capacity: 8\n", printedValue);
    }

    @Test
    public void testPrintPassengerList() {
        TravelPackage travelPackage = new TravelPackage("Summer Vacation", 20);
        Passenger passenger1 = new StandardPassenger(1L,"John",100.0);
        Passenger passenger2 = new StandardPassenger(2L,"Alice",200.0);
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        //process to check for print output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printPassengerList();

        System.setOut(System.out);
        String printedValue = outContent.toString().trim();

        assertEquals("""
                Travel Package: Summer Vacation
                Passenger Capacity: 20
                Number of Passengers Enrolled: 2
                Passenger List:
                 - Name: John, Passenger Number: 1
                 - Name: Alice, Passenger Number: 2""", printedValue);
    }

    @Test
    public void testPrintPassengerDetails() {
        TravelPackage travelPackage = new TravelPackage("Summer Vacation", 20);
        Passenger passenger1 = new StandardPassenger(1L,"John", 10.0);
        Activity hiking = new Activity("Hiking", "Enjoy the scenic beauty", 50.0, 10);
        travelPackage.addPassenger(passenger1);
        passenger1.signUp(hiking);

        //process to check for print output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printPassengerDetails(passenger1);

        System.setOut(System.out);
        String printedValue = outContent.toString().trim();
        assertEquals("""
                Passenger Name: John
                Passenger Number: 1
                Signed Up Activities:
                 - Activity: Hiking
                   Destination: Beach Resort
                   Price Paid: ₹50.0""", printedValue);
    }

    @Test
    public void testPrintActivitiesWithSpace() {
        Destination destination1 = new Destination("Beach Resort");
        Activity hiking = new Activity("Hiking", "Enjoy the scenic beauty", 50.0, 0);
        Activity snorkeling = new Activity("Snorkeling", "Explore marine life", 80.0, 8);
        destination1.addActivity(hiking);
        destination1.addActivity(snorkeling);

        TravelPackage travelPackage = new TravelPackage("Summer Vacation", 20);
        travelPackage.addDestination(destination1);

        //process to check for print output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printActivitiesWithCapacity();

        System.setOut(System.out);
        String printedValue = outContent.toString().trim();

        assertEquals("""
                Activities with Available Space:
                 - Activity: Snorkeling
                   Available capacity: 8""", printedValue);
    }

}