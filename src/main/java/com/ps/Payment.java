package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Payment {

    public static void addTransaction(ArrayList<Transactions> transactions) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter description of payment: ");
        String descriptionInput = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendorInput = scanner.nextLine();
        System.out.print("Enter amount: ");
        float amountInput = Math.abs(scanner.nextFloat());

        transactions.add(new Transactions(
                LocalDate.now(),
                LocalTime.now().withNano(0),
                descriptionInput,
                vendorInput,
                -amountInput));

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

        System.out.println("Payment Complete!");

    }
}
