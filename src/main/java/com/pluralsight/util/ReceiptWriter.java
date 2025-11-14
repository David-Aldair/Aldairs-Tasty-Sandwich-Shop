package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) {

        //generating a unique timestamp for the receipt file
        String timestamp = generateTimestamp();

        //folder already exists
        String folderPath = "receipts/";

        //the full file name (e.g. receipt-"timestamp".txt)
        String fileName = folderPath + "receipt-" + timestamp + ".txt";

        //try with resources the order summary to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            //writing the formatted order summary into the file
            writer.write(order.getOrderSummary());

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }

    }

    //this method creates a timestamp string used for naming receipts
    private static String generateTimestamp() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy  HH:mm");

        //returns the current date/time formatted as a string
        return LocalDateTime.now().format(formatter);
    }
}
