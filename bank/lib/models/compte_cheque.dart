import 'compte.dart';
import 'transaction.dart';

class CompteCheque extends Compte {
  CompteCheque(super.id, super.solde);

  @override
  void validateTransaction(Transaction transaction) {
    // ...existing code...
  }
}
