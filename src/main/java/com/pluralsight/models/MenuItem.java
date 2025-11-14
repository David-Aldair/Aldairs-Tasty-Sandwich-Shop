package com.pluralsight.models;

/*this class represents anything in the system hat has a price
this allows us to put all the items in one pricedItem arraylist instead
of putting them in 3 different lists(sandwiches, drinks, chips)*/
public interface MenuItem {

    /*gets the price of the item and also
    returns it as a double*/
    double getPrice();
}
