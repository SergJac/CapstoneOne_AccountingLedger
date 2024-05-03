package com.ps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.YearMonth;

public class Ledger {
    public static void displayLedgerMenu(Scanner scanner, ArrayList<Transactions> transactions) {
        boolean exitSubMenu = false;

        String ledgerChoice;

        do {

            System.out.println("Ledger Options:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");


            System.out.print("Enter your choice: ");
            ledgerChoice = scanner.nextLine().toUpperCase();


            switch (ledgerChoice) {
                case "A":
                    System.out.println("You selected: All");
                    displayAllTransactions(transactions);
                    break;
                case "D":
                    System.out.println("You selected: Deposits");

                    onlyDepositTransaction(transactions);
                    break;
                case "P":
                    System.out.println("You selected: Payments");

                    onlyPaymentTransaction(transactions);
                    break;
                case "R":
                    System.out.println();
                    System.out.println("You selected: Reports");
                    int choice;
                    do {
                        System.out.println("1) Month to date");
                        System.out.println("2) Previous Month");
                        System.out.println("3) Year to Date");
                        System.out.println("4) Previous Year");
                        System.out.println("5) Search by Vendor");
                        System.out.println("0) Back");

                        System.out.print("Please enter your selection: ");
                        choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                System.out.println("You Chose: Month to Date");
                                monthToDateTransactions(transactions);
                                break;
                            case 2:
                                System.out.println("You Chose: Previous Month");
                                lastMonthTransactions(transactions);
                                break;
                            case 3:
                                System.out.println("You Chose: Year to Date");
                                yearToDateTransactions(transactions);
                                break;
                            case 4:
                                System.out.println("You Chose: Previous Year");
                                lastYearTransactions(transactions);
                                break;
                            case 5:
                                System.out.println("You Chose: Search by Vendor");
                                searchByVendor(transactions);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid choice! Try again!");
                        }

                    } while (choice != 0);

                    break;
                case "H":
                    exitSubMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            System.out.println();

        } while (!exitSubMenu);

    }

    private static void displayAllTransactions(ArrayList<Transactions> transactions) {
        for (int i = transactions.size() - 1; i >= 0; i--) { // this line allows the user to see the latest entry first
            Transactions transaction = transactions.get(i);
            String formattedTransaction = String.format("%s|%s|%s|%s|%.2f",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
            System.out.println(formattedTransaction);
        }
    }

    private static void onlyDepositTransaction(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            if (transaction.getDescription().toLowerCase().contains("deposit")|| transaction.getAmount() > 0) { // this line searches for any value that has the word "deposit" or that has a number greater than 0
                searchResults.add(transaction);
            }

        }

        if (!searchResults.isEmpty()) {
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

    private static void onlyPaymentTransaction(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            if (transaction.getDescription().toLowerCase().contains("payment") || transaction.getAmount() < 0) {
                searchResults.add(transaction);
            }

        }

        if (!searchResults.isEmpty()) {
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

    private static void monthToDateTransactions(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        LocalDate currentDate = currentDate();
        LocalDate startDate = currentDate.withDayOfMonth(1);
        LocalDate endDate = currentDate.plusDays(1);


        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDate();

            if (!transactionDate.isBefore(startDate) && transactionDate.isBefore(endDate)) {
                searchResults.add(transaction);
            }
        }

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

    private static void lastMonthTransactions(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();


        LocalDate startDate = currentDate.minusMonths(1).withDayOfMonth(1);

        YearMonth lastMonth = YearMonth.from(currentDate.minusMonths(1));
        LocalDate endDate = lastMonth.atEndOfMonth().plusDays(1); // Plus one day to include transactions up to the end of the last day


        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDate();

            if (!transactionDate.isBefore(startDate) && transactionDate.isBefore(endDate)) {
                searchResults.add(transaction);
            }
        }

        if (!searchResults.isEmpty()) {
            System.out.println("Transactions from last month:");
            // Print the search results
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

    private static void yearToDateTransactions(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        LocalDate startDate = LocalDate.of(currentDate.getYear(), 1, 1);

        LocalDate endDate = currentDate.plusDays(1);

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDate();

            if (!transactionDate.isBefore(startDate) && transactionDate.isBefore(endDate)) {
                searchResults.add(transaction);
            }

        }

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

    private static void lastYearTransactions(ArrayList<Transactions> transactions) {
        ArrayList<Transactions> searchResults = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        LocalDate startDate = LocalDate.of(currentDate.getYear() - 1, 1, 1);


        LocalDate endDate = LocalDate.of(currentDate.getYear(), 1, 1);

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDate();

            if (!transactionDate.isBefore(startDate) && transactionDate.isBefore(endDate)) {
                searchResults.add(transaction);
            }
        }

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

    private static void searchByVendor(ArrayList<Transactions> transactions) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the vendor name to search for: ");
        String vendorName = scanner.nextLine();

        ArrayList<Transactions> searchResults = new ArrayList<>();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions transaction = transactions.get(i);
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                searchResults.add(transaction);
            }
        }

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
