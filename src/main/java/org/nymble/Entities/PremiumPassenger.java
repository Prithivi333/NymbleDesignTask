package org.nymble.Entities;

import java.util.List;

public class PremiumPassenger extends Passenger {

    public PremiumPassenger(Long passengerNumber, String passengerName) {
        super(passengerNumber, passengerName);
    }

    @Override
    public void signUp(Activity activity){
        if(activity.getCapacity()<1)throw new RuntimeException(activity.getName()+" is full!");
        this.addSignedUpActivity(activity);
        activity.setCapacity(activity.getCapacity()-1);
        System.out.println("Signed up for:"+activity.getName());
    }
}
