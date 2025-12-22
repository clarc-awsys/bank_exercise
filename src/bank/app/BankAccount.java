package bank.app;

public interface BankAccount {
  /**
   * @param amount
   */
  void deposit(double amount);
  /**
   * @param amount
   */
  void withdraw(double amount);
  /**
   * @return Current balance of account.
   */
  double getBalance();
  /**
   * @return true or false
   */
  boolean isFrozen();
}
