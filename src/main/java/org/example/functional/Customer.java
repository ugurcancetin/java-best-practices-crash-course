package org.example.functional;

import java.util.List;
import java.util.Objects;

public final class Customer {
  private final String name;
  private final List<Order> orders;

  public Customer(String name, List<Order> orders) {
    this.name = Objects.requireNonNull(name, "Customer name cannot be null");
    this.orders = List.copyOf(orders); // Ensures immutability
  }

  public String getName() {
    return name;
  }

  public List<Order> getOrders() {
    return orders; // Safe return, since List.copyOf() makes it immutable
  }

  @Override
  public String toString() {
    return "Customer{name='" + name + "', orders=" + orders + "}";
  }
}
