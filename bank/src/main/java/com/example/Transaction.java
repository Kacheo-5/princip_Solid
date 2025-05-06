package com.example;

import java.time.LocalDate;

public class Transaction {
    private static int idCounter = 1;
    private final int id;
    private final TransactionType type;
    private double montant;
    private final LocalDate date;

    public Transaction(TransactionType type, double montant) {
        this.id = idCounter++;
        this.type = type;
        this.montant = montant;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDate() {
        return date;
    }
}
