# Subs by Aldair: Sandwich Ordering System

## Overview

Subs by Aldair is a fully interactive, console-based sandwich ordering system written in Java.
Customers can create a full order by choosing sandwiches, drinks, and chips. Each sandwich is highly customizable with bread types, sizes, meats, cheeses, toppings, and sauces.

When checkout is complete, the app automatically generates a receipt and saves it to a file.

---

## Core Functionality & Features

### Main Menu

| Command | Description          |
| ------- | -------------------- |
| **1**   | Start a new order    |
| **0**   | Exit the application |

---

### Order Menu

| Command | Description  |
| ------- | ------------ |
| **1**   | Add Sandwich |
| **2**   | Add Drink    |
| **3**   | Add Chips    |
| **4**   | Checkout     |
| **0**   | Cancel Order |

---

## Sandwich Builder: Fully Customizable

### Bread Options

* White
* Wheat
* Rye
* Wrap

### Sizes

* 4"
* 8"
* 12"

### Toasted?

* Yes / No

### Add Ingredients

Each category is selected via a loop menu:

| Category             | Pricing                                                   |
| -------------------- | --------------------------------------------------------- |
| **Meats**            | Premium; price varies by sandwich size; *extra adds cost* |
| **Cheese**           | Premium; *extra adds cost*                                |
| **Regular Toppings** | Free                                                      |
| **Sauces**           | Free                                                      |

The user can add as many of each as they want.

---

## Drinks & Chips

### Drinks

User enters:

* Flavor
* Size (Small, Medium, Large, X-Large)

### Chips

User enters:

* Chip name (Doritos, Lays, etc.)

Price is fixed at **$1.50**.

---

## Receipt Generation

At checkout:

1. The program displays a complete order summary.
2. The user confirms the purchase.
3. A receipt file is created in the `receipts/` folder.
4. The file is named using a timestamp, for example:

```
receipt-2025-11-13_18-17-15.txt
```

### Example Receipt Output

```
Order for: Aldair
---------------------------

Sandwiches:

8" White sandwich (Toasted)
Meats: steak (extra)
Cheeses: american
Toppings:
Sauces: chipotle mayo
Total Price: $12.10


Drinks:
 - Large Coke - $3.00

Chips:
 - Doritos Chips - $1.50

Total: $16.60
```

---

## Application Screens

### Main Menu (Example)

*(Insert screenshot here)*

### Order Summary Example

*(Insert screenshot here)*

---

## Code Spotlight: Multi-Step Sandwich Assembly

A key feature of the project is the step-by-step sandwich builder.
The menu loops allow a user to add unlimited meats, cheeses, toppings, and sauces, while each step is processed safely and clearly with switch statements.

### Example

```java
while (true) {
    System.out.println("""
        Add Meat:
        1) Add meat
        0) No meat / Done
    """);

    String choice = scanner.nextLine();

    switch (choice) {
        case "1" -> {
            System.out.print("Enter meat name: ");
            String meat = scanner.nextLine();
            System.out.print("Extra? (Y/N): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("Y");
            sandwich.addMeat(meat, extra);
        }
        case "0" -> { return; }
        default -> System.out.println("Invalid choice.\n");
    }
}
```

### Why This Is Interesting

* Each menu loop feels like placing a real sandwich order.
* The switch/case structure keeps the logic readable and clean.
* Invalid input is always handled safely.
* Easily expandable (new toppings, new sizes, etc.).

---

## Receipt File Format

Receipts are saved using a consistent structure:

```
Order for: <Customer Name>
---------------------------

<Each sandwich summary>

<Drink list>

<Chip list>

Total: $XX.XX
```

---

## Final Notes

Subs by Aldair demonstrates strong Java fundamentals including:

* Object-oriented design
* Interfaces and inheritance
* Input handling
* Clean menu-driven navigation
* File output using BufferedWriter
* Modular, maintainable methods

This project showcases both technical skill and user-focused design.

