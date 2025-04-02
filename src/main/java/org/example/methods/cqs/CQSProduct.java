package org.example.methods.cqs;

public class CQSProduct {
    private int stock;

    public CQSProduct(int stock) {
      this.stock = stock;
    }

    // Sadece durumu değiştiren komut metodu
    public void sellProduct(int quantity) {
      if (quantity > stock) {
        throw new IllegalArgumentException("Not enough stock available");
      }
      stock -= quantity;
    }

    // Sadece veri döndüren sorgu metodu
    public int getStock() {
      return stock;
    }
}
