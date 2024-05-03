package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Payment {

    // Method to add payment transactions
    public static void addTransaction(ArrayList<Transactions> transactions) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for payment description
        System.out.print("Enter description of payment: ");
        String descriptionInput = scanner.nextLine();

        // Prompt user for vendor (recipient) name
        System.out.print("Enter vendor: ");
        String vendorInput = scanner.nextLine();

        // Prompt user for payment amount
        System.out.print("Enter amount: ");
        float amountInput = Math.abs(scanner.nextFloat());

        // Create new transaction object with current date, time, and user inputs,
        // and negate the amount to represent a payment (debit)
        transactions.add(new Transactions(
                LocalDate.now(),
                LocalTime.now().withNano(0),
                descriptionInput,
                vendorInput,
                -amountInput));

        // Write the new transaction to the transactions.txt file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt"))) {
            for (Transactions newTransaction : transactions) {
                writer.write(String.format("%s|%s|%s|%s|%.2f%n",
                        newTransaction.getDate(),
                        newTransaction.getTime(),
                        newTransaction.getDescription(),
                        newTransaction.getVendor(),
                        newTransaction.getAmount()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Confirmation message for payment completion
        System.out.println("Payment Complete!");
    }
}
