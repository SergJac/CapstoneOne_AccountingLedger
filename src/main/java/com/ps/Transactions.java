package com.ps;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transactions {

    // Fields to store transaction details
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private float amount;

    // Constructor to initialize transaction object with provided details
    public Transactions(LocalDate date, LocalTime time, String description, String vendor, float amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // Getter for transaction date
    public LocalDate getDate() {
        return date;
    }

    // Setter for transaction date
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter for transaction time
    public LocalTime getTime() {
        return time;
    }

    // Setter for transaction time
    public void setTime(LocalTime time) {
        this.time = time;
    }

    // Getter for transaction description
    public String getDescription() {
        return description;
    }

    // Setter for transaction description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for transaction vendor
    public String getVendor() {
        return vendor;
    }

    // Setter for transaction vendor
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    // Getter for transaction amount
    public float getAmount() {
        return amount;
    }

    // Setter for transaction amount
    public void setAmount(float amount) {
        this.amount = amount;
    }

    // Override toString() method to provide a string representation of the transaction object
    @Override
    public String toString() {
        return "Transactions{" +
                "date=" + date +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", amount=" + amount +
                '}';
    }
}
