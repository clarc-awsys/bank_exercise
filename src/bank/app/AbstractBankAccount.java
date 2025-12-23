package bank.app;

public abstract class AbstractBankAccount implements BankAccount {
  /**
   * Abstract balance variable.
   */
  private double balance;
  /**
   * Account status variable.
   * Code Review: Try to initialize isFrozen and balance using a Constructor
   */
  private boolean isFrozen;
  /**
   * AbstractBankAccount Constructor.
   */
  public AbstractBankAccount() { // Missing Constructor from specs sheet
    setFrozen(false);
  }
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
    if (isFrozen()) { // Checkstyle error - no space between if and (
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
    if (isFrozen()) { // Checkstyle error - no space between if and (
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
  public void freezeAccount() {
    setFrozen(true);
    // Checkstyle error - space between println and (
    System.out.println("Account has been frozen.");
  }
  /**
   * Unfreezes the account.
   */
  public void unfreezeAccount() {
    setFrozen(false);
 // Checkstyle error - space between println and (
    System.out.println("Account has been unfrozen.");
  }
}
