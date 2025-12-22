package bank.app;

public interface BankAccount {
  void depoist();
  void withdraw();
  double getBalance();
  boolean isFrozen();
}
