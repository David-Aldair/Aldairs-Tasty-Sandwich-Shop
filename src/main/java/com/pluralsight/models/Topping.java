package com.pluralsight.models;

/*making this an abstract class allows us to define some shared variables
and methods in one place, while letting child classes handle differences*/
public abstract class Topping implements MenuItem {

    //properties for this class
    private String name;

    //set to boolean if the customer wants extra of the topping
    private boolean extra;

    //constructor for these properties
    public Topping(String name, boolean extra) {
        this.name = name;
        this.extra = extra;
    }

    //getters for these properties
    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return extra;
    }
}
