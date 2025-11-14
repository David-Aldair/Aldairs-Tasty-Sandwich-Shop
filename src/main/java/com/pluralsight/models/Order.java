package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

/*the Order class represents a single customer order.
It keeps track of all sandwiches, drinks, and chips added to the order,
and calculates the total price of all items.*/
public class Order {

    //creating lists to store the different items in the order
    private String customerName;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chipsList;

    //storing total price of all the items in the order
    private double totalPrice;

    //constructor
    //initializing the class properties
    public Order(String customerName) {
        this.customerName = customerName;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chipsList = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    //addSandwich method
    //adding sandwich to list and increasing the total
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
        totalPrice += sandwich.getPrice();
    }

    //addDrink method
    //adding drink to list and increasing the total
    public void addDrink(Drink drink) {
        drinks.add(drink);
        totalPrice += drink.getPrice();
    }

    //addChips method
    //adding chips to list and increasing the total
    public void addChips(Chips chips) {
        chipsList.add(chips);
        totalPrice += chips.getPrice();
    }
}
