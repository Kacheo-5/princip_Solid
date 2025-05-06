import 'transaction.dart';
import '../enums/type_transaction.dart';

abstract class Compte {
  int id;
  double solde;
  List<Transaction> transactions;

  Compte(this.id, this.solde) : transactions = [];

  void deposer(double montant) {
    solde += montant;
    transactions.add(Transaction(TransactionType.depot, montant));
  }

  void retirer(double montant) {
    if (solde >= montant) {
      solde -= montant;
      transactions.add(Transaction(TransactionType.retrait, montant));
    } else {
      throw Exception('Solde insuffisant');
    }
  }

  void validateTransaction(Transaction transaction);
}
