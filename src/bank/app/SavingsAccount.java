package bank.app;

public class SavingsAccount extends AbstractBankAccount {
  /**
   * Stores name of account owner.
   */
  private String ownerName;
  /**
   * @return owner name.
   */
  public String getOwnerName() {
    return ownerName;
  }
  /**
   * @param savingsOwnerName
   */
  public void setOwnerName(final String savingsOwnerName) {
    this.ownerName = savingsOwnerName;
  }
  /**
   * @param savingsOwnerName
   */
  public SavingsAccount(final String savingsOwnerName) {
    setOwnerName(savingsOwnerName);
    System.out.println(getOwnerName());
  }
}
