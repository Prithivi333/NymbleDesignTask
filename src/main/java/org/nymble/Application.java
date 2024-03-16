package org.nymble;

import org.nymble.Entities.*;

import java.util.ArrayList;

class PassengerFactory {
    public static Passenger createPassenger(String passengerType, String name, Long id, double balance) {
        return switch (passengerType.toLowerCase()) {
            case "standard" -> new StandardPassenger(id, name, balance);
            case "premium" -> new PremiumPassenger(id, name);
            case "gold" -> new GoldPassenger(id, name, balance);
            default -> throw new IllegalArgumentException("Invalid passenger type provided: " + passengerType);
        };
    }
}

public class Application {
    public static void main(String[] args) {
        // Dynamically create a standard passenger

        Passenger standardPassenger = PassengerFactory.createPassenger("standard", "John", 123L, 100.0);

        // Dynamically create a premium passenger
        Passenger premiumpassenger = PassengerFactory.createPassenger("premium", "Alice", 456L, 0.0);

        // Accessing balance for a standard passenger
        if (standardPassenger instanceof StandardPassenger passenger) {
            System.out.println("Standard passenger balance: ₹" + passenger.getBalance());
        }
        Activity jogging=new Activity("Jogging","Cardio!!!",1.0,5);
        Destination bangalore=new Destination("Bangalore");
        bangalore.addActivity(jogging);
        TravelPackage bglTour=new TravelPackage("Bangalore tour",10);
        bglTour.addDestination(bangalore);
        bglTour.printItinerary();
        bglTour.addPassenger(standardPassenger);
        standardPassenger.signUp(jogging);
        bglTour.printActivitiesWithCapacity();
        bglTour.printPassengerList();
    }
}