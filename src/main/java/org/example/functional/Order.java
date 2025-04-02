package org.example.functional;

import java.util.Objects;

public final class Order {

  private final String id;
  private final double total;

  public Order(String id, double total) {
    this.id = Objects.requireNonNull(id, "Order ID cannot be null");
    this.total = total;
  }

  public String getId() {
    return id;
  }

  public double getTotal() {
    return total;
  }

  public void sendNotification() {
  }

  @Override
  public String toString() {
    return "Order{id='" + id + "', total=" + total + "}";
  }
}
