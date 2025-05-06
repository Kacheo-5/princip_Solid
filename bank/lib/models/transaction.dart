import '../enums/type_transaction.dart';

class Transaction {
  static int idCounter = 1;
  final int id;
  final TransactionType type;
  double montant;
  final DateTime date;

  Transaction(this.type, this.montant)
    : id = idCounter++,
      date = DateTime.now();

  int getId() => id;

  TransactionType getType() => type;

  double getMontant() => montant;

  void setMontant(double montant) {
    this.montant = montant;
  }

  DateTime getDate() => date;
}
