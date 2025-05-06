package com.example;

import java.util.ArrayList;
import java.util.List;

public class CompteRepository {
    private final List<Compte> comptes = new ArrayList<>();

    public void addCompte(Compte compte) {
        comptes.add(compte);
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public Compte findCompteByNumero(String numero) {
        return comptes.stream()
                .filter(compte -> compte.getNumero().equals(numero))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Compte not found."));
    }
}
