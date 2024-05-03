package com.ps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Read transactions from file
        ArrayList<Transactions> transactions = readTransactionsFromFile("transactions.txt");

        String choice;

        do {

        System.out.println("Home Screen");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment(Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");

        System.out.println();

        System.out.print("Please enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextLine().toUpperCase();

        System.out.println();

        switch (choice) {
            case "D":
                System.out.println("You chose Add Deposit");
                // Add deposit transaction
                Deposit.addTransactions(transactions);
                break;
            case "P":
                System.out.println("You chose Make Payment(Debit)");
                // Add deposit transaction
                Payment.addTransaction(transactions);
                break;
            case "L":
                System.out.println("You chose Ledger");
                // Display ledger menu
                Ledger.displayLedgerMenu(scanner, transactions);
                break;
            case "X":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                break;

        }

        System.out.println();


    } while(choice !="X");

}

    // Read transactions from file and populate ArrayList
    public static ArrayList<Transactions> readTransactionsFromFile(String filename) {
        ArrayList<Transactions> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split("\\|");

                    if (parts.length == 5) {

                        // Parse transaction details
                        LocalDate date = LocalDate.parse(parts[0]);
                        LocalTime time = LocalTime.parse(parts[1]);
                        String description = parts[2];
                        String vendor = parts[3];
                        float amount = Float.parseFloat(parts[4]);
                        Transactions transaction = new Transactions(date, time, description, vendor, amount);

                        // Add transaction to ArrayList
                        transactions.add(transaction);
                    } else {

                        // Print error message for invalid format
                        System.out.println("Invalid format in line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }
}

