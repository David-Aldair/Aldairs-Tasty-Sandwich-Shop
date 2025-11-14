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

    //method that adds premium meat topping to sandwich
    //premium toppings have a price that depends on the sandwich size
    public void addMeat(String meatName, boolean extra){
        PremiumTopping meat = new PremiumTopping(meatName, extra);

        //calculating the price based on sandwich size
        double price = 0.0;

        price = switch (sandwichSize){
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0.00;
        };

        //adding extra cost for extra meat if the user wants it
        if(extra) {

            //this adds the extra meat charge
            price += switch (sandwichSize) {
                case 4 -> 0.50;
                case 8 -> 1.00;
                case 12 -> 1.50;
                default -> 0.00;
            };
        }

        //adding to list so it updates the total
        meats.add(meat);
        totalPrice += price;
    }

    //method that adds cheese to the sandwich
    //cheese also counts as a premium topping
    public void addCheese(String cheeseName, boolean extra){
        PremiumTopping cheese = new PremiumTopping(cheeseName, extra);

        //calculating the price based on sandwich type
        double price = 0.0;

        price = switch (sandwichSize){
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0.00;

        };
        //adding extra cost for extra cheese if the user wants it
        if(extra){

            //this adds the extra cheese charge
            price += switch(sandwichSize){
                case 4 -> 0.30;
                case 8 -> 0.60;
                case 12 -> 0.90;
                default -> 0.00;
            };
        }

        //adding to list so it updates the total
        cheeses.add(cheese);
        totalPrice += price;
    }

    //method for adding a regular topping
    //these are free
    public void addTopping(String toppingName){
        RegularTopping topping = new RegularTopping(toppingName, false);

        //adding to list and updates total even though it's 0
        regularToppings.add(topping);
    }

    //method for adding a sauce
    //sauces are also free
    public void addSauce(String sauceName) {
        RegularTopping sauce = new RegularTopping(sauceName, false);

        //adding to list and updates even though it's 0
        sauces.add(sauce);
    }

    //returning the current total price of the sandwich
    @Override
    public double getPrice() {
        return totalPrice;
    }
}
