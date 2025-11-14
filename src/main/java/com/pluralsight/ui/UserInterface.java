package com.pluralsight.ui;


import com.pluralsight.models.*;

import java.util.Scanner;

public class UserInterface {

    //scanner for users input
    private Scanner scanner = new Scanner(System.in);

    //this method is the main entry point for running the user interface
    public void start() {

        //main app loop that keeps running until the user chooses to exit
        while (true) {

            System.out.println("""
        ========================================
                    Subs by Aldair
                  Whatever you want!
                     We make it!
        ========================================
        1) New Order
        0) Exit

        Choose an option:
        """);

            //reading user input
            String choice = scanner.nextLine();

            //processing the menu choice using a switch expression
            switch (choice) {

                //starting a new customer order
                case "1" -> startNewOrder();

                //exiting the entire program
                case "0" -> {
                    System.out.println("Thank you for visiting Subs by Aldair!");
                    return;     // leaves the start() method → ends program
                }

                //this handles invalid entries so the menu continues running
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private void startNewOrder() {

        System.out.println("What name should this order be under?");
        String customerNname = scanner.nextLine();

        //create a new order object to store the customer name
        Order order = new Order(customerNname);

        //another loop for the order menu
        while (true) {

            System.out.println("""
                ========================================
                             Subs by Aldair
                           Create a New Order
                ========================================
                
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order
                
                Please enter your choice:
                """);

            String input = scanner.nextLine();

            //decide what action to take based on the users choice
            switch (input) {

                //adding a sandwich to the current order
                case "1" -> addSandwichToOrder(order);

                //adding a drink to the order
                case "2" -> addDrinkToOrder(order);

                //adding chips to the order
                case "3" -> addChipsToOrder(order);

                // Checkout → finish order → write receipt → return to main menu
                case "4" -> {
                    checkout(order);
                    return;     // leaves startNewOrder() and goes back to the main menu
                }

                //cancelling the order completely
                case "0" -> {
                    System.out.println("Order cancelled.\n");
                    return;     // exits the order menu entirely
                }

                //anything else is invalid
                default -> System.out.println("Invalid choice. Try again!\n");
            }
        }
    }

}
