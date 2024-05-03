package com.ps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.YearMonth;

public class Ledger {
    // This method displays the ledger menu and handles user input to navigate through ledger options.
    public static void displayLedgerMenu(Scanner scanner, ArrayList<Transactions> transactions) {

        boolean exitSubMenu = false; // Flag to control exiting the ledger submenu
        String ledgerChoice; // Stores user's choice

        // Loop until user chooses to exit
        do {
            // Display ledger options
            System.out.println("Ledger Options:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            // Prompt user for choice
            System.out.print("Enter your choice: ");
            ledgerChoice = scanner.nextLine().toUpperCase(); // Convert input to uppercase for case-insensitive comparison

            // Process user choice using a switch statement
            switch (ledgerChoice) {
                case "A":
                    System.out.println("You selected: All");
                    displayAllTransactions(transactions); // Display all transactions
                    break;
                case "D":
                    System.out.println("You selected: Deposits");
                    onlyDepositTransaction(transactions); // Display only deposit transactions
                    break;
                case "P":
                    System.out.println("You selected: Payments");
                    onlyPaymentTransaction(transactions); // Display only payment transactions
                    break;
                case "R":
                    System.out.println();
                    System.out.println("You selected: Reports");

                    int choice;
                    // Inner loop for report submenu
                    do {
                        // Display report options
                        System.out.println("1) Month to date");
                        System.out.println("2) Previous Month");
                        System.out.println("3) Year to Date");
                        System.out.println("4) Previous Year");
                        System.out.println("5) Search by Vendor");
                        System.out.println("0) Back");

                        System.out.print("Please enter your selection: ");
                        choice = scanner.nextInt(); // Read user's report choice
                        scanner.nextLine();

                        // Process report choice
                        switch (choice) {
                            case 1:
                                System.out.println("You Chose: Month to Date");
                                monthToDateTransactions(transactions); // Display month-to-date transactions
                                break;
                            case 2:
                                System.out.println("You Chose: Previous Month");
                                lastMonthTransactions(transactions); // Display last month's transactions
                                break;
                            case 3:
                                System.out.println("You Chose: Year to Date");
                                yearToDateTransactions(transactions); // Display year-to-date transactions
                                break;
                            case 4:
                                System.out.println("You Chose: Previous Year");
                                lastYearTransactions(transactions); // Display last year's transactions
                                break;
                            case 5:
                                System.out.println("You Chose: Search by Vendor");
                                searchByVendor(transactions); // Search transactions by vendor
                                break;
                            case 0:
                                break; // Exit report submenu
                            default:
                                System.out.println("Invalid choice! Try again!");
                        }

                    } while (choice != 0); // Continue report submenu until user chooses to go back

                    break;
                case "H":
                    exitSubMenu = true; // Set flag to exit ledger submenu
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            System.out.println(); // Print an empty line for clarity

        } while (!exitSubMenu); // Continue main menu until user chooses to exit
    }

    // Method to display all transactions
    private static void displayAllTransactions(ArrayList<Transactions> transactions) {
        for (int i = transactions.size() - 1; i >= 0; i--) { // Loop through transactions in reverse order
            Transactions transaction = transactions.get(i);
            // Format the transaction details into a string for display
            String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
            System.out.println(formattedTransaction);
        }
    }

    // Method to display only deposit transactions
    private static void onlyDepositTransaction(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>(); // Initialize a list to store search results
        for (int i = transactions.size() - 1; i >= 0; i--) { // Loop through transactions in reverse order
            Transactions transaction = transactions.get(i);
            if (transaction.getDescription().toLowerCase().contains("deposit")|| transaction.getAmount() > 0) { // this line searches for any value that has the word "deposit" or that has a number greater than 0
                searchResults.add(transaction);
            }

        }

        // Display search results or message if no transactions found
        if (!searchResults.isEmpty()) { // Check if search results list is not empty
            System.out.println("Search results:");
            for (Transactions transaction : searchResults) { // Loop through search results
                String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount());
                System.out.println(formattedTransaction);
            }
        } else {
            System.out.println("No matching transactions found.");
        }

    }

    // Method to display only payment transactions
    private static void onlyPaymentTransaction(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            // Check if the transaction description contains "payment" or if the amount is less than 0
            if (transaction.getDescription().toLowerCase().contains("payment") || transaction.getAmount() < 0) {
                searchResults.add(transaction);
            }

        }

        // Display search results or message if no transactions found
        if (!searchResults.isEmpty()) { // Check if search results list is not empty
            System.out.println("Search results:");
            for (Transactions transaction : searchResults) {
                String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount());
                System.out.println(formattedTransaction);
            }
        } else {
            System.out.println("No matching transactions found.");
        }

    }

    private static LocalDate currentDate() {
        return LocalDate.now();
    }

    // Method to display month-to-date transactions
    private static void monthToDateTransactions(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        LocalDate currentDate = currentDate();
        LocalDate startDate = currentDate.withDayOfMonth(1); // Get the start date of the current month
        LocalDate endDate = currentDate.plusDays(1); // Makes today's date the end date

        // Iterate over transactions to find month-to-date transactions
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDate();

            // Check if the transaction date is within the current month
            if (!transactionDate.isBefore(startDate) && transactionDate.isBefore(endDate)) {
                searchResults.add(transaction);
            }
        }

        // Display search results or message if no transactions found
        if (!searchResults.isEmpty()) {
            System.out.println("Month-to-date Transactions:");
            for (Transactions result : searchResults) {
                String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                        result.getDate(),
                        result.getTime(),
                        result.getDescription(),
                        result.getVendor(),
                        result.getAmount());
                System.out.println(formattedTransaction);
            }
        } else {
            System.out.println("No matching transactions found for the month-to-date.");
        }
    }

    // Method to display transactions from the last month
    private static void lastMonthTransactions(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        // Calculate the start date of the last month
        LocalDate startDate = currentDate.minusMonths(1).withDayOfMonth(1);

        // Calculate the end date of the last month (plus one day to include transactions up to the end of the last day)
        YearMonth lastMonth = YearMonth.from(currentDate.minusMonths(1));
        LocalDate endDate = lastMonth.atEndOfMonth().plusDays(1);

        // Iterate over transactions to find transactions from the last month
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDate();

            // Check if the transaction date is within the last month
            if (!transactionDate.isBefore(startDate) && transactionDate.isBefore(endDate)) {
                searchResults.add(transaction);
            }
        }

        // Display search results or message if no transactions found
        if (!searchResults.isEmpty()) {
            System.out.println("Transactions from last month:");

            for (Transactions result : searchResults) {
                String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                        result.getDate(),
                        result.getTime(),
                        result.getDescription(),
                        result.getVendor(),
                        result.getAmount());
                System.out.println(formattedTransaction);
            }
        } else {
            System.out.println("No matching transactions found for last month.");
        }
    }

    // Method to display year-to-date transactions
    private static void yearToDateTransactions(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        LocalDate startDate = LocalDate.of(currentDate.getYear(), 1, 1);

        LocalDate endDate = currentDate.plusDays(1);

        // Iterate over transactions to find year-to-date transactions
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDate();

            // Check if the transaction date is within the current year
            if (!transactionDate.isBefore(startDate) && transactionDate.isBefore(endDate)) {
                searchResults.add(transaction);
            }

        }

        // Display search results or message if no transactions found
        if (!searchResults.isEmpty()) {
            System.out.println("Year-to-date Transactions:");

            for (Transactions result : searchResults) {
                String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                        result.getDate(),
                        result.getTime(),
                        result.getDescription(),
                        result.getVendor(),
                        result.getAmount());
                System.out.println(formattedTransaction);
            }
        } else {
            System.out.println("No matching transactions found for year-to-date.");
        }

    }

    // Method to display transactions from the last year
    private static void lastYearTransactions(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        LocalDate startDate = LocalDate.of(currentDate.getYear() - 1, 1, 1);


        LocalDate endDate = LocalDate.of(currentDate.getYear(), 1, 1);

        // Iterate over transactions to find transactions from the last year
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDate();

            // Iterate over transactions to find transactions from the last year
            if (!transactionDate.isBefore(startDate) && transactionDate.isBefore(endDate)) {
                searchResults.add(transaction);
            }
        }

        // Display search results or message if no transactions found
        if (!searchResults.isEmpty()) {
            System.out.println("Transactions from last year:");

            for (Transactions result : searchResults) {
                String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                        result.getDate(),
                        result.getTime(),
                        result.getDescription(),
                        result.getVendor(),
                        result.getAmount());
                System.out.println(formattedTransaction);
            }
        } else {
            System.out.println("No matching transactions found for last year.");
        }
    }

    // Method to search transactions by vendor name
    private static void searchByVendor(ArrayList<Transactions> transactions) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the vendor name to search for: ");
        String vendorName = scanner.nextLine();

        ArrayList<Transactions> searchResults = new ArrayList<>();

        // Iterate over transactions to find transactions with the specified vendor name
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            // Check if the vendor name of the transaction matches the user input (case-insensitive)
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                searchResults.add(transaction);
            }
        }

        // Display search results or message if no transactions found
        if (!searchResults.isEmpty()) {
            System.out.println("Transactions by vendor '" + vendorName + "':");

            for (Transactions result : searchResults) {
                String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                        result.getDate(),
                        result.getTime(),
                        result.getDescription(),
                        result.getVendor(),
                        result.getAmount());
                System.out.println(formattedTransaction);
            }
        } else {
            System.out.println("No transactions found for vendor '" + vendorName + "'.");
        }

    }
}
