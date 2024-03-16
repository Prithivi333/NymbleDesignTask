package org.nymble.Entities;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private Integer capacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public void setItinerary(List<Destination> itinerary) {
        this.itinerary = itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    // Method to add destination to itinerary
    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    // Method to add passenger to travel package
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    // Method to print itinerary
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Activities:");
            for (Activity activity : destination.getActivities()) {
                System.out.println(" - Name: " + activity.getName());
                System.out.println("   Description: " + activity.getDescription());
                System.out.println("   Cost: ₹" + activity.getCost());
                System.out.println("   Capacity: " + activity.getCapacity());
            }
        }
    }

    // Method to print details of activities with available space
    public void printActivitiesWithCapacity() {
        System.out.println("Activities with Available Space:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getCapacity()>0) {
                    System.out.println(" - Activity: " + activity.getName());
                    System.out.println("   Available capacity: " + activity.getCapacity());
                }
            }
        }
    }

    // Method to print passenger list
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + capacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println(" - Name: " + passenger.getPassengerName() + ", Passenger Number: " + passenger.getPassengerNumber());
        }
    }


    // Method to print details of an individual passenger
    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Name: " + passenger.getPassengerName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if (passenger instanceof StandardPassenger) {
            StandardPassenger standardPassenger = (StandardPassenger) passenger;
            System.out.println("Balance: " + standardPassenger.getBalance());
        }
        else if(passenger instanceof GoldPassenger){
            GoldPassenger goldPassenger=(GoldPassenger) passenger;
            System.out.println("Balance: " + goldPassenger.getBalance());
        }
        System.out.println("Signed Up Activities:");
        for (Activity activity : passenger.getActivities()) {
            System.out.println(" - Activity: " + activity.getName());
            System.out.println("   Destination: " + getDestinationForActivity(activity).getName());
            System.out.println("   Price Paid: ₹" + activity.getCost());
        }
    }

    // Method to get destination for an activity
    private Destination getDestinationForActivity(Activity activity) {
        for (Destination destination : itinerary) {
            for (Activity act : destination.getActivities()) {
                if (act.getName().equals(activity.getName())) {
                    return destination;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "TravelPackage{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", itinerary=" + itinerary +
                ", passengers=" + passengers +
                '}';
    }
}
