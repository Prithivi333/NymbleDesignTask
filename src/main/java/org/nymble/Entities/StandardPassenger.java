package org.nymble.Entities;

import java.util.List;

public class StandardPassenger extends Passenger {
    private Double balance;

    public StandardPassenger(Long passengerNumber, String passengerName, Double balance) {
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
        if(this.balance< activity.getCost())throw new NoBalanceException("No sufficient Balance to sign up for: "+activity.getName());
        if(activity.getCapacity()<1)throw new RuntimeException(activity.getName()+" is full!");
        this.balance-= activity.getCost();
        activity.setCapacity(activity.getCapacity()-1);
        this.addSignedUpActivity(activity);
        System.out.println("Signed up for:"+activity.getName()+". Current balance is:₹"+this.balance);
    }
}
