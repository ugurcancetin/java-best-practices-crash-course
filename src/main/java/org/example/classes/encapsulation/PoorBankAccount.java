package org.example.classes.encapsulation;

public class PoorBankAccount {

  //direct access
  public double balance;

  public PoorBankAccount(double balance) {
    this.balance = balance; // No validation
  }

  public void withdraw(double amount) {
    this.balance -= amount; // No checks!
  }
}
