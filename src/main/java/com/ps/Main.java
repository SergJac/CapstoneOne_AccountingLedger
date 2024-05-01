package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Transactions> transaction = new ArrayList<>();

        transaction.add(new Transactions(LocalDate.of(2023, 4, 15), LocalTime.of(10, 13, 25), "ergonomic keyboard", "Amazon", -89.50f));
        transaction.add(new Transactions(LocalDate.of(2023, 4, 15), LocalTime.of(11, 15), "Invoice 1001 paid", "Joe", 1500.00f));

        while (true) {

            System.out.println("Home Screen");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment(Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            System.out.println();

            System.out.print("Please enter your choice: ");
            String choice = scanner.nextLine().toUpperCase();

            System.out.println();

            switch (choice) {
                case "D":
                    System.out.println("You chose Add Deposit");
                    Deposit.addTransactions(transaction);
                    break;
                case "P":
                    System.out.println("You chose Make Payment(Debit)");
                    Payment.addTransaction(transaction);
                    break;
                case "L":
                    System.out.println("You chose Ledger");
                    Ledger.displayLedgerMenu(scanner, transaction);
                    break;
                case "X":
                    System.out.println("Exiting the program");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;

            }

            System.out.println();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv"))) {
                for (Transactions transactionList : transaction) {
                    writer.write(String.format("%s|%s|%s|%s|%.2f%n",
                            transactionList.getDate(),
                            transactionList.getTime(),
                            transactionList.getDescription(),
                            transactionList.getVendor(),
                            transactionList.getAmount()));
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }
}