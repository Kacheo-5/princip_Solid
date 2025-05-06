package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
    private static int idCounter = 1;
    private final int id;
    private final String numero;
    private final LocalDate dateCreation;
    private double solde;
    private final List<Transaction> transactions;

    public Compte(String numero) {
        this.id = idCounter++;
        this.numero = numero;
        this.dateCreation = LocalDate.now();
        this.solde = 0.0;
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        if (transaction.getType() == TransactionType.RETRAIT && solde < transaction.getMontant()) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal.");
        }
        solde += transaction.getType() == TransactionType.DEPOT ? transaction.getMontant() : -transaction.getMontant();
        transactions.add(transaction);
    }

    public abstract void validateTransaction(Transaction transaction);
}
