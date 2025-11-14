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

    //getters
    public String getCustomerName(){
        return customerName;
    }

    public double getTotal() {
        return totalPrice;
    }

    //returning a list of all sandwiches in the order
    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    //returning a list of all drinks in the order
    public List<Drink> getDrinks() {
        return drinks;
    }

    //returning a list of all chips in the order
    public List<Chips> getChips() {
        return chipsList;
    }

    //getOrderSummary
    //returning a formatted string of all items and total
    public String getOrderSummary() {

        // Start summary with the customer's name instead of "Order Summary"
        StringBuilder summary = new StringBuilder();

        summary.append("Order for: ")
                .append(customerName)
                .append("\n---------------------------\n");

        //adding sandwiches section if not empty
        if (!sandwiches.isEmpty()) {
            summary.append("\nSandwiches:\n\n");
            for (Sandwich s : sandwiches) {
                summary.append(s.getSummary()).append("\n");
            }
        }

        //adding drinks section if not empty
        if (!drinks.isEmpty()) {
            summary.append("\nDrinks:\n");
            for (Drink d : drinks) {
                summary.append(" - ").append(d.toString()).append("\n");
            }
        }

        //adding chips section if not empty
        if (!chipsList.isEmpty()) {
            summary.append("\nChips:\n");
            for (Chips c : chipsList) {
                summary.append(" - ").append(c.toString()).append("\n");
            }
        }

        //adding the total price formatted to 2 decimal places
        summary.append("\nTotal: $").append(String.format("%.2f", totalPrice));

        //returning the final summary as a string
        return summary.toString();
    }
}
