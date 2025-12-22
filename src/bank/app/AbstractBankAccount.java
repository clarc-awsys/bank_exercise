package bank.app;

public abstract class AbstractBankAccount implements BankAccount {
  /**
   * Abstract balance variable.
   */
  private double balance;
  /**
   * Account status variable.
   */
  private boolean isFrozen = false;
  /**
   * @return returns true or false.
   */
  public boolean isFrozen() {
    return isFrozen;
  }
  /**
   * Setter of setFrozen.
   * @param isFrozenStatus
   */
  public void setFrozen(final boolean isFrozenStatus) {
    this.isFrozen = isFrozenStatus;
  }
  /**
   * Sets the value of balance.
   * @param accountBalance
   */
  public void setBalance(final double accountBalance) {
    this.balance = accountBalance;
  }
  /**
   * Adds amount to current balance.
   * @param amount
   */
  public void deposit(final double amount) {
    if (isFrozen()) {
      System.out.println("Account has been frozen. Cannot Deposit");
      return;
    } else if (amount <= 0) {
      System.out.println("The deposit amount must be positive.");
      return;
    } else {
      setBalance(amount + getBalance()); // Add deposit amount to balance
      System.out.println("Deposited: PHP " + amount);
    }
  }
  /**
   * @param amount
   */
  public void withdraw(final double amount) {
    if (isFrozen()) {
      System.out.println("Account has been frozen. Cannot Withdraw");
      return;
    } else if (amount > getBalance()) {
      System.out.println("Insufficient balance.");
      return;
    } else if (amount <= 0) {
      System.out.println("The withdrawn amount must be positive.");
    } else {
      setBalance(getBalance() - amount); // Subtract withdraw amount to balance
      System.out.println("Withdrawn: PHP " + amount);
    }
  }
  /**
   * @return balance.
   */
  public double getBalance() {
    return balance;
  }
  /**
   * Freezes the account.
   */
  void freezeAcount() {
    setFrozen(true);
    System.out.println("Account has been frozen.");
  }
  /**
   * Unfreezes the account.
   */
  void unfreezeAccount() {
    setFrozen(false);
    System.out.println("Account has been unfrozen.");
  }
}
