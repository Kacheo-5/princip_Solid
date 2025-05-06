package com.example;

import java.time.LocalDate;

public class CompteEpargne extends Compte {
    private final LocalDate dateFinBlocage;

    public CompteEpargne(String numero, LocalDate dateFinBlocage) {
        super(numero);
        this.dateFinBlocage = dateFinBlocage;
    }

    public LocalDate getDateFinBlocage() {
        return dateFinBlocage;
    }

    @Override
    public void validateTransaction(Transaction transaction) {
        if (transaction.getType() == TransactionType.RETRAIT && LocalDate.now().isBefore(dateFinBlocage)) {
            throw new IllegalArgumentException("Withdrawals are not allowed during the blocking period.");
        }
    }
}
