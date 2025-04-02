package org.example.classes.encapsulation;

public class GoodBankAccount {

  private double balance;

  public GoodBankAccount(double initialBalance) {
    if (initialBalance < 0) {
      throw new IllegalArgumentException("Balance cannot be negative");
    }
    this.balance = initialBalance;
  }

  public double getBalance() {
    return balance;
  }

  public void withdraw(double amount) {
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds");
    }
    balance -= amount;
  }
}
