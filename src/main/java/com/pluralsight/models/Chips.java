package com.pluralsight.models;

public class Chips implements MenuItem {

    //properties for chips
    private String name;
    private double price;

    //constructor
    public Chips(String name){
        this.name = name;
        this.price = 1.50;
    }

    //getter for chip name
    public String getName() {
        return name;
    }

    //returning the price of the chips
    @Override
    public double getPrice() {
        return price;
    }

    //toString method returns a readable summary of the chips
    @Override
    public String toString() {
        return name + " Chips - $" + String.format("%.2f", price);
    }
}
