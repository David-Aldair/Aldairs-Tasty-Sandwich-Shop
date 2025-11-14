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

    //addSandwichToOrder method
    private void addSandwichToOrder(Order order) {

        System.out.println("Creating a new sandwich:\n");

        System.out.println("""
            Choose your bread type:
            1) White
            2) Wheat
            3) Rye
            4) Wrap
            
            Enter choice:
            """);

        String breadChoice = scanner.nextLine();

        //this will hold the chosen bread name
        String breadType = "";

        //determine the breadType based on user input
        switch (breadChoice) {
            case "1" -> breadType = "White";
            case "2" -> breadType = "Wheat";
            case "3" -> breadType = "Rye";
            case "4" -> breadType = "Wrap";
            default -> {

                //exit early if choice is invalid
                System.out.println("Invalid choice. Sandwich cancelled.\n");
                return;
            }
        }

        System.out.println("""
            Choose your size:
            1) 4"
            2) 8"
            3) 12"
            
            Enter choice:
            """);

        String sizeChoice = scanner.nextLine();

        //this will hold a int sandwich size
        int size = 0;

        //converts menu choice into actual int size
        switch (sizeChoice) {
            case "1", "4" -> size = 4;
            case "2", "8" -> size = 8;
            case "3", "12" -> size = 12;
            default -> {
                System.out.println("Invalid size. Sandwich cancelled.\n");
                return;
            }
        }

        System.out.println("Would you like it toasted? (Y/N)");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("Y");

        // Create the sandwich object using the choices above
        Sandwich sandwich = new Sandwich(breadType, size, toasted);


        //each of these allows the user to add a category of toppings
        addMeats(sandwich);
        addCheese(sandwich);
        addRegularToppings(sandwich);
        addSauces(sandwich);

        //adds final sandwich to the customer's order
        order.addSandwich(sandwich);

        System.out.println("Sandwich added!\n");

        //prevents immediate return to menu
        System.out.println("Press ENTER to return to the order menu");
        scanner.nextLine();
    }

    //addMeats method
    private void addMeats(Sandwich sandwich) {

        //this loop lets the customer add multiple meats
        while (true) {
            System.out.println("""
            Add Meat:
            1) Add meat
            0) No meat / Done
            """);

            String choice = scanner.nextLine();

            switch (choice) {

                //user wants to add a meat
                case "1" -> {
                    System.out.print("Enter meat name: ");
                    String meat = scanner.nextLine();

                    System.out.print("Extra? (Y/N): ");
                    boolean extra = scanner.nextLine().equalsIgnoreCase("Y");

                    //adds selected meat to the sandwich
                    sandwich.addMeat(meat, extra);
                    System.out.println("Meat added!\n");
                }

                //user is done adding meats and exits loop
                case "0" -> {
                    return;
                }

                //invalid input
                default -> System.out.println("Invalid choice.\n");
            }
        }
    }

    //addCheese method
    private void addCheese(Sandwich sandwich) {

        //this loop lets customers add multiple cheese
        while (true) {
            System.out.println("""
            Add Cheese:
            1) Add cheese
            0) No cheese/ done
            """);

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> {
                    //ask for the cheese type
                    System.out.print("Enter cheese name: ");
                    String cheese = scanner.nextLine();

                    //ask whether they want an extra portion of that cheese
                    System.out.print("Extra? (Y/N): ");
                    boolean extra = scanner.nextLine().equalsIgnoreCase("Y");

                    //adds this cheese topping to the sandwich
                    sandwich.addCheese(cheese, extra);

                    System.out.println("Cheese added!\n");
                }

                //user is done adding cheese and exits loop
                case "0" -> {
                    return;
                }

                //invalid input
                default -> System.out.println("Invalid choice.\n");
            }
        }
    }

    //method for adding toppings
    private void addRegularToppings(Sandwich sandwich) {

        //this loop lets customers add multiple toppings
        while (true) {
            System.out.println("""
            Add Toppings:
            1) Add topping
            0) No toppings / Done
            """);

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> {

                    //asks for topping type
                    System.out.print("Enter topping: ");
                    String topping = scanner.nextLine();

                    //adds topping to sandwich
                    sandwich.addTopping(topping);

                    System.out.println("Topping added!\n");
                }

                //user is done adding toppings and exits loop
                case "0" -> {
                    return;
                }

                //invalid input
                default -> System.out.println("Invalid choice.\n");
            }
        }
    }

    //method for adding sauces
    private void addSauces(Sandwich sandwich) {

        //this loop lets customers add multiple sauces
        while (true) {

            System.out.println("""
        Add Sauces:
        1) Add sauce
        0) No sauces / Done
        """);

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> {

                    //asks for sauce type from the user
                    System.out.print("Enter sauce: ");
                    String sauce = scanner.nextLine();

                    //adds sauce to the sandwich
                    sandwich.addSauce(sauce);

                    System.out.println("Sauce added!\n");
                }

                //user is done adding sauces and exits loop
                case "0" -> {
                    return;
                }

                //invalid input
                default -> System.out.println("Invalid choice.\n");
            }
        }
    }

    //method for adding a drink to the order
    private void addDrinkToOrder(Order order) {

        System.out.println("""
        ==========================
               Add a Drink
        ==========================

        Enter drink flavor:
        """);

        String flavor = scanner.nextLine();

        System.out.println("""
        Choose a size:
        1) Small
        2) Medium
        3) Large
        4) X-Large

        Enter choice:
        """);

        String sizeChoice = scanner.nextLine();
        String size = "";

        //convert the menu choice into a size string
        switch (sizeChoice) {
            case "1" -> size = "Small";
            case "2" -> size = "Medium";
            case "3" -> size = "Large";
            case "4" -> size = "X-Large";

            //invalid choice
            default -> {
                System.out.println("Invalid size. Drink not added.\n");
                return;
            }
        }

        //create drink object using flavor and size
        Drink drink = new Drink(flavor, size);

        //add the completed drink to the order
        order.addDrink(drink);

        System.out.println("Drink added!\n");

        //pause before returning to menu
        System.out.println("Press ENTER to return to the order menu");
        scanner.nextLine();
    }

    //method for adding chips to the order
    private void addChipsToOrder(Order order) {

        System.out.println("""
        ==========================
               Add Chips
        ==========================

        Enter chip type:
        """);

        //reads chip name
        String chipName = scanner.nextLine();

        //creates Chips object using the name
        Chips chips = new Chips(chipName);

        //adds chips to the current order
        order.addChips(chips);

        System.out.println("Chips added!\n");

        //pause before returning to menu
        System.out.println("Press ENTER to return to the order menu");
        scanner.nextLine();
    }
}
