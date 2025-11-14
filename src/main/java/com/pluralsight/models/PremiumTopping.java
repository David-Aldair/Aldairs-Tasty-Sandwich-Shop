package com.pluralsight.models;

public class PremiumTopping extends Topping{

    //constants for premium topping price
    //static and final because the price is the same for all premium topping
    private static final double NORMAL_PRICE = 1.00;  //normal premium topping cost

    //extra topping cost
    private static final double EXTRA_PRICE = 2.00;

    public PremiumTopping(String name, boolean extra) {

        // super is calling the parent constructor to set name and extra
        super(name, extra);
    }

    //if extra is true, the topping cost more, and then it returns the final price as a double
    @Override
    public double getPrice() {
        if (isExtra()) {
            return NORMAL_PRICE + EXTRA_PRICE;
        } else {
            return NORMAL_PRICE;
        }
    }

    //this returns a readable string version of the topping with its price
    @Override
    public String toString() {

        // super.toString gives you the name and extra part
        return super.toString() + " - $" + String.format("%.2f", getPrice());
    }
}
