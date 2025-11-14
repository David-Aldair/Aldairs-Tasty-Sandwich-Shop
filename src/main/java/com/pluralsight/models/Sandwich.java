package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich implements MenuItem{

    //properties
    private String breadType;
    private int sandwichSize;
    private boolean toasted;
    private double totalPrice;

    //arraylist for toppings
    private ArrayList<Topping> meats;
    private ArrayList<Topping> cheeses;
    private ArrayList<Topping> regularToppings;
    private ArrayList<Topping> sauces;

    //constructor
    public Sandwich(String breadType, int sandwichSize, boolean toasted) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.toasted = toasted;

        //initializing lists so toppings can be added later
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();

        //setting the base prize depending on the size, using switch case instead of if statements
        totalPrice = switch (sandwichSize) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };
    }
}
