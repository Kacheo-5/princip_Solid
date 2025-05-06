package com.example;

import java.time.LocalDate;
import java.util.Scanner;

public class BankingApp {
    private final CompteService service;

    public BankingApp(CompteService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1-Créer un compte");
            System.out.println("2-Afficher les comptes");
            System.out.println("3-Ajouter une Transaction à un compte");
            System.out.println("4-Lister les transactions d’un compte");
            System.out.println("5-Quitter");
            System.out.print("Choisissez une option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createCompte(scanner);
                    break;
                case 2:
                    displayComptes();
                    break;
                case 3:
                    addTransaction(scanner);
                    break;
                case 4:
                    listTransactions(scanner);
                    break;
                case 5:
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Option invalide.");
            }
        }
    }

    private void createCompte(Scanner scanner) {
        System.out.println("1-Compte Cheque");
        System.out.println("2-Compte Epargne");
        System.out.print("Choisissez le type de compte: ");
        int type = scanner.nextInt();

        if (type == 1) {
            Compte compte = service.createCompteCheque();
            System.out.println("Compte créé: " + compte.getNumero());
        } else if (type == 2) {
            System.out.print("Entrez la durée de blocage (en jours): ");
            int days = scanner.nextInt();
            LocalDate dateFinBlocage = LocalDate.now().plusDays(days);
            Compte compte = service.createCompteEpargne(dateFinBlocage);
            System.out.println("Compte créé: " + compte.getNumero());
        } else {
            System.out.println("Type de compte invalide.");
        }
    }

    private void displayComptes() {
        service.getRepository().getComptes().forEach(compte -> {
            System.out.println("Compte: " + compte.getNumero() + ", Solde: " + compte.getSolde());
        });
    }

    private void addTransaction(Scanner scanner) {
        System.out.print("Entrez le numéro du compte: ");
        String numero = scanner.next();
        System.out.println("1-Dépôt");
        System.out.println("2-Retrait");
        System.out.print("Choisissez le type de transaction: ");
        int type = scanner.nextInt();
        System.out.print("Entrez le montant: ");
        double montant = scanner.nextDouble();

        TransactionType transactionType = type == 1 ? TransactionType.DEPOT : TransactionType.RETRAIT;
        Transaction transaction = new Transaction(transactionType, montant);

        try {
            service.addTransaction(numero, transaction);
            System.out.println("Transaction ajoutée.");
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    private void listTransactions(Scanner scanner) {
        System.out.print("Entrez le numéro du compte: ");
        String numero = scanner.next();

        try {
            Compte compte = service.getRepository().findCompteByNumero(numero);
            compte.getTransactions().forEach(transaction -> {
                System.out.println("Transaction: " + transaction.getType() + ", Montant: " + transaction.getMontant() + ", Date: " + transaction.getDate());
            });
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}
