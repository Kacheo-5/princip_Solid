package com.example;

import java.time.LocalDate;

public class CompteService {
    private final CompteRepository repository;
    private int chequeCounter = 1;
    private int epargneCounter = 1;

    public CompteService(CompteRepository repository) {
        this.repository = repository;
    }

    public Compte createCompteCheque() {
        String numero = String.format("CHEQUE_%04d", chequeCounter++);
        CompteCheque compte = new CompteCheque(numero);
        repository.addCompte(compte);
        return compte;
    }

    public Compte createCompteEpargne(LocalDate dateFinBlocage) {
        String numero = String.format("EPARGNE_%04d", epargneCounter++);
        CompteEpargne compte = new CompteEpargne(numero, dateFinBlocage);
        repository.addCompte(compte);
        return compte;
    }

    public void addTransaction(String numero, Transaction transaction) {
        Compte compte = repository.findCompteByNumero(numero);
        compte.validateTransaction(transaction);
        compte.addTransaction(transaction);
    }

    public CompteRepository getRepository() {
        return repository;
    }
}
