package bank.app;

public abstract class AbstractBankAccount {
  private double balance;
  private boolean isFrozen = false;
  
  public boolean isFrozen() {
    return isFrozen;
  }

  public void setFrozen(boolean isFrozen) {
    this.isFrozen = isFrozen;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  void deposit(double amount) {
    if(isFrozen()) {
      System.out.println("Account has been frozen. Cannot Deposit");
      return;
    } else if (amount <= 0) {
      System.out.println("The deposit amount must be positive.");
      return;
    } else {
      setBalance(amount + getBalance()); // Add deposit amount to current balance
    }
    
  }
  
  void withdraw(double amount) {
    
  }
  
  double getBalance() {
    return balance;
  }
  
  void freezeAcount() {
    System.out.println("Account has been frozen.");
    setFrozen(true);
  }
  
  void unfreezeAccount() {
    setFrozen(false);
  }
}
