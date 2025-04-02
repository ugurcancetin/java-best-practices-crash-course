package org.example.methods.cqs;

public class Product {

  private int stock;

  public Product(int stock) {
    this.stock = stock;
  }

  // CQS'yi ihlal eden metod
  public int sellProduct(int quantity) {
    if (quantity > stock) {
      throw new IllegalArgumentException("Not enough stock available");
    }
    stock -= quantity;
    return stock; // Hem durumu değiştiriyor hem de veri döndürüyor
  }

  public int getStock() {
    return stock;
  }
}