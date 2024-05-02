package com.ps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Transactions> transaction = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    LocalDate date = LocalDate.parse(parts[0]);
                    LocalTime time = LocalTime.parse(parts[1]);
                    String description = parts[2];
                    String vendor = parts[3];
                    float amount = Float.parseFloat(parts[4]);
                    Transactions transactions = new Transactions(date, time, description, vendor, amount);
                    transaction.add(transactions);
                } else {
                    System.out.println("Invalid format in line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;

            }

            System.out.println();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))) {
                Transactions newTransaction = transaction.get(transaction.size() - 1);
                writer.write(String.format("%s|%s|%s|%s|%.2f%n",
                        newTransaction.getDate(),
                        newTransaction.getTime(),
                        newTransaction.getDescription(),
                        newTransaction.getVendor(),
                        newTransaction.getAmount()));

            } catch (IOException e) {
                e.printStackTrace();
            }

            }

        }

}