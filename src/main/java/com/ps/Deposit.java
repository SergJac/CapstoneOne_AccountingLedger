package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
public class Deposit {

    // Method to add deposit transactions
    public static void addTransactions(ArrayList<Transactions> transactions) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for deposit description
        System.out.print("Enter description of deposit: ");
        String descriptionInput = scanner.nextLine();

        // Prompt user for their name (vendor)
        System.out.print("Enter your name: ");
        String vendorInput = scanner.nextLine();

        // Prompt user for deposit amount
        System.out.print("Enter amount: ");
        float amountInput = Math.abs(scanner.nextFloat());

        // Create new transaction object with current date, time, and user inputs
        transactions.add(new Transactions(
                LocalDate.now(),
                LocalTime.now().withNano(0),
                descriptionInput,
                vendorInput,
                amountInput));

        // Write the new transaction to the transactions.txt file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt"))) {
            for(Transactions newTransaction : transactions) {
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

        // Confirmation message for deposit completion
        System.out.println("Deposit Complete!");
    }

    }
