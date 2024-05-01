package com.ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ledger {
    public static void displayLedgerMenu(Scanner scanner, ArrayList<Transactions> allTransactions) {
        while (true) {
            // Display the Ledger submenu
            System.out.println("Ledger Options:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            // Read user input
            System.out.print("Enter your choice: ");
            String ledgerChoice = scanner.nextLine().toUpperCase(); // Convert input to uppercase

            // Process the user's choice
            switch (ledgerChoice) {
                case "A":
                    System.out.println("You selected: All");
                    displayAllTransactions(allTransactions);
                    break;
                case "D":
                    System.out.println("You selected: Deposits");
                    // Call a method to display only deposits
                    onlyDepositTransaction(allTransactions);
                    break;
                case "P":
                    System.out.println("You selected: Payments");
                    // Call a method to display only payments
                    onlyPaymentTransaction(allTransactions);
                    break;
                case "R":
                    System.out.println("You selected: Reports");
                    // Call a method to generate reports
                    break;
                case "H":
                    System.out.println("Returning to Home");
                    return; // Exit the submenu and return to the main menu
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            System.out.println();

        }

    }

    private static void displayAllTransactions(ArrayList<Transactions> allTransactions) {
        for (int i = allTransactions.size() - 1; i >= 0; i--) {
            Transactions transaction = allTransactions.get(i);
            String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
            System.out.println(formattedTransaction);
        }
    }

    private static void onlyDepositTransaction(ArrayList<Transactions> depositTransaction) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        for (int i = depositTransaction.size() - 1; i >= 0; i--) {
            Transactions transaction = depositTransaction.get(i);
            if (transaction.getDescription().toLowerCase().contains("deposit")) {
                searchResults.add(transaction);
            }

        }

        if (!searchResults.isEmpty()) {
            System.out.println("Search results:");
            for (Transactions transactions : searchResults) {
                String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                        transactions.getDate(),
                        transactions.getTime(),
                        transactions.getDescription(),
                        transactions.getVendor(),
                        transactions.getAmount());
                System.out.println(formattedTransaction);
            }
        } else {
            System.out.println("No matching transactions found.");
        }

    }

    private static void onlyPaymentTransaction(ArrayList<Transactions> paymentTransaction) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        for (int i = paymentTransaction.size() - 1; i >= 0; i--) {
            Transactions transaction = paymentTransaction.get(i);
            if (transaction.getDescription().toLowerCase().contains("payment") || transaction.getAmount() < 0) {
                searchResults.add(transaction);
            }

        }

        if (!searchResults.isEmpty()) {
            System.out.println("Search results:");
            for (Transactions transactions : searchResults) {
                String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                        transactions.getDate(),
                        transactions.getTime(),
                        transactions.getDescription(),
                        transactions.getVendor(),
                        transactions.getAmount());
                System.out.println(formattedTransaction);
            }
        } else {
            System.out.println("No matching transactions found.");
        }

    }

}
