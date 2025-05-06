package com.example;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Entry point of the application.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        CompteRepository repository = new CompteRepository();
        CompteService service = new CompteService(repository);
        BankingApp app = new BankingApp(service);
        app.start();
    }
}
