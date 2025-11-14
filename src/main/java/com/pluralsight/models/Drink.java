package com.pluralsight.models;

public class Drink implements MenuItem {

    //properties for the drink
    private String flavor;
    private String size;
    private final double price;

    //constructor
    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;

        //setting the price depending on size
        this.price = switch (size.toLowerCase()){
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            case "x-large" -> 3.50;
            default -> 0.00;
        };
    }

    //getters for flavor and size
    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    //returning the price of the drink
    @Override
    public double getPrice(){
        return price;
    }

    // toString method returns a readable summary of the drink
    @Override
    public String toString() {
        return size + " " + flavor + " - $" + String.format("%.2f", price);
    }
}
