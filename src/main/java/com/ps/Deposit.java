package com.ps;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
public class Deposit {
    public static void addTransactions(ArrayList<Transactions> transaction) {
        Scanner scanner2 = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String vendorInput = scanner2.nextLine();
        System.out.print("Enter Amount You Wish to Deposit: ");
        float amountInput = scanner2.nextFloat();

        // Adding user input transaction
        transaction.add(new Transactions(
                LocalDate.now(),
                LocalTime.now().withNano(0),
                "Deposit",
                vendorInput,
                amountInput
        ));

        System.out.println();

    }

}
