package bank.app;



public class Main {
  public static void main(String[] args) {
    SavingsAccount newAccount = new SavingsAccount("Kenneth Ligutom"); // Test Case # 1
    runTestCases(newAccount);
  }
  
  public static void runTestCases(SavingsAccount account) {
    account.deposit(1000); // Test Case #2
    account.deposit(0); // Test Case #3
    account.deposit(-500); // Test Case #4
    account.withdraw(500); // Test Case #5
    account.withdraw(1500); // Test Case #6
    account.withdraw(-100); // Test Case #7
    
    account.freezeAcount();
    account.deposit(11500); // Test Case #8
    account.withdraw(500); // Test Case #9
    
    account.unfreezeAccount();
    account.withdraw(100); // Test Case #10
    System.out.println(account.isFrozen()); // Test Case #11
    System.out.println(account.getBalance()); // Test Case #12
    
  }
}
