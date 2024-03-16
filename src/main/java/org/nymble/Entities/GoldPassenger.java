package org.nymble.Entities;

import java.util.List;

public class GoldPassenger extends Passenger {
    private Double balance;

    public GoldPassenger(Long passengerNumber, String passengerName, Double balance) {
        super(passengerNumber, passengerName);
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public void signUp(Activity activity){
        Double discountedPrice= activity.getCost()*0.90;
        if(this.balance< discountedPrice)throw new NoBalanceException("No sufficient Balance to sign up for: "+activity.getName());
        if(activity.getCapacity()<1)throw new RuntimeException(activity.getName()+" is full!");
        this.balance-= discountedPrice;
        this.addSignedUpActivity(activity);
        activity.setCapacity(activity.getCapacity()-1);
        System.out.println("Signed up for:"+activity.getName()+". Current balance is:₹"+this.balance);
    }
}
