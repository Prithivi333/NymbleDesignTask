package org.nymble.Entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Passenger {
    private Long passengerNumber;
    private String passengerName;
    private List<Activity>activities;

    public Passenger() {
    }

    public Passenger(Long passengerNumber, String passengerName) {
        this.passengerNumber = passengerNumber;
        this.passengerName = passengerName;
        this.activities=new ArrayList<>();
    }

    public Long getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(Long passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public abstract void signUp(Activity activity);

    // Method to add signed up activity
    public void addSignedUpActivity(Activity activity) {
        activities.add(activity);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerNumber=" + passengerNumber +
                ", passengerName='" + passengerName + '\'' +
                ", activities=" + activities +
                '}';
    }
}
