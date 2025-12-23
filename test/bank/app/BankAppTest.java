package bank.app;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAppTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  SavingsAccount account;
  @BeforeEach
  void setup() {
    this.account = new SavingsAccount("Khan Santos"); // Instantiates new object -- acts like a reset
    outContent.reset();
    System.setOut(new PrintStream(outContent));
  }
  
  @Test
  void getOwnerNameMethod_WhenInstantiating_ReturnsOwnerName() {
    assertEquals("Khan Santos", account.getOwnerName(), "Name does not match Khan Santos.");
  }
  
  @Test
  void testDepositMethodAndGetBalanceMethod_WhenAmountIsValid_ReturnDepositInput() {
    account.deposit(4000);
    assertEquals(4000, account.getBalance(), "Deposited amount does not match");
  }
  
  @Test
  void testDepositMethod_IfAmountIsInvalid_ReturnsErrorMessage() {
    account.deposit(-1238);
    assertEquals("The deposit amount must be positive.", outContent.toString().trim());
  }
  
  @Test
  void testDepositMethod_IfAmountIsZero_ReturnsErrorMessage(){
    account.deposit(0);
    assertEquals("The deposit amount must be positive.", outContent.toString().trim());
  }
  
  @Test
  void testDepositMethod_IfAmountIsValid_ReturnsDepositAmount() {
    account.deposit(1000);
    assertEquals("Deposited: PHP 1000.0", outContent.toString().trim());
  }
  
  @Test
  void testFreezeAccountMethodAndDepositMethod_IfAccountIsFrozen_ReturnsErrorMessage() {
    account.freezeAccount();
    account.deposit(1281);
    assertTrue(outContent.toString().contains("Account has been frozen. Cannot Deposit"));
  }
  
  @Test
  void testWithdrawMethod_IfAmountIsValid_ReturnsWithdrawAmount() {
    account.deposit(5000);
    account.withdraw(500);
    
    assertTrue(outContent.toString().contains("PHP 500"));
  }
  
  @Test
  void testWithdrawMethod_IfAmountIsInvalid_ReturnsErrorMessage() {
    account.withdraw(500);
    assertEquals("Insufficient balance.", outContent.toString().trim());
  }
  
  @Test
  void testWithdrawMethod_IfAccountIsFrozen_ReturnsErrorMessage() {
    account.freezeAccount();
    account.withdraw(700);
    
    assertTrue(outContent.toString().contains("Account has been frozen. Cannot Withdraw"));
  }
  
  @Test
  void testWithdrawMethod_IfAmountIsZeroOrLess_ReturnsErrorMessage() {
    account.withdraw(-100);
    assertEquals("The withdrawn amount must be positive.", outContent.toString().trim());
  }
  
  @Test
  void testUnfreezeMethod_IfAccountIsUnfrozen_ReturnsFalse() {
    account.freezeAccount();
    account.unfreezeAccount();
    assertFalse(account.isFrozen());
  }
  
  @Test
  void testMain_ReturnsVoid() {
    Main.main(null);
  }
  
  

}
