package bank.app;

public final class Main {
  /**
   * Default constructor.
   */
  private Main() {
    super();
  }
  /**
   * Main function.
   * @param args
   */
  public static void main(final String[] args) {
    SavingsAccount newAccount =
        new SavingsAccount("Kenneth Ligutom"); // Test Case # 1
    runTestCases(newAccount);
  }
  /**
   * @param account
   */
  public static void runTestCases(final SavingsAccount account) {
    final int oneThousand = 1000;
    final int fiveHundred = 500;
    final int oneHundred = 100;
    final int elevenThousandFiveHundred = 11500;
    account.deposit(oneThousand); // Test Case #2
    account.deposit(0); // Test Case #3
    account.deposit(-fiveHundred); // Test Case #4
    account.withdraw(fiveHundred); // Test Case #5
    account.withdraw(oneThousand + fiveHundred); // Test Case #6
    account.withdraw(-oneHundred); // Test Case #7
    // Freezing Account
    account.freezeAccount();
    account.deposit(elevenThousandFiveHundred); // Test Case #8
    account.withdraw(fiveHundred); // Test Case #9
    // Unfreezing Account
    account.unfreezeAccount();
    account.withdraw(oneHundred); // Test Case #10
    System.out.println(account.isFrozen()); // Test Case #11
    System.out.println(account.getBalance()); // Test Case #12
  }
}
