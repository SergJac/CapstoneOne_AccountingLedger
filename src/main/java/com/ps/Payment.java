package com.ps;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Payment {

    public static void addTransaction(ArrayList<Transactions> transactions) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for vendor and amount
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
    }

}
