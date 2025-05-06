import 'compte.dart';
import 'transaction.dart';
import '../enums/type_transaction.dart';

class CompteEpargne extends Compte {
  CompteEpargne(super.id, super.solde);

  @override
  void validateTransaction(Transaction transaction) {
    // ...existing code...
  }
}
