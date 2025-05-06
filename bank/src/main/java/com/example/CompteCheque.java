package com.example;

public class CompteCheque extends Compte {
    private static final double TRANSACTION_FEE_PERCENTAGE = 0.008;

    public CompteCheque(String numero) {
        super(numero);
    }

    @Override
    public void validateTransaction(Transaction transaction) {
        double fee = transaction.getMontant() * TRANSACTION_FEE_PERCENTAGE;
        transaction.setMontant(transaction.getMontant() - fee);
    }
}
