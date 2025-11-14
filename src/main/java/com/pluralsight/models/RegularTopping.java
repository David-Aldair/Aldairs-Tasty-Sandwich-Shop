package com.pluralsight.models;

public class RegularTopping extends Topping {

    //constants for pricing regular toppings
    private static final double NORMAL_PRICE = 0.50;//normal price for a regular topping

    //extra topping charge if needed
    private static final double EXTRA_PRICE = 1.00;

    //calling the superclass constructor to initialize the name and extra fields
    public RegularTopping(String name, boolean extra) {

        //calling the topping's constructor
        super(name, extra);
    }
}
