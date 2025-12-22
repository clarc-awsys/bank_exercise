package bank.app;

public class SavingsAccount {
  private String ownerName;
  
  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public SavingsAccount(String ownerName) {
    setOwnerName(ownerName);
  }
  
  
}
