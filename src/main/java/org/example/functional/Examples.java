package org.example.functional;

import java.util.ArrayList;
import java.util.List;

class User {

  public boolean isActive() {
    return true;
  }

  public String getEmail() {
    return "ugurcan2020@gmail.com";
  }
}

public class Examples {

  public static void main(String[] args) {
    List<String> names = List.of("Alice", "Bob", "Charlie");
    List<String> upperNames = new ArrayList<>();

    //🔴 Why is this bad?
    //Too verbose for a simple transformation.
    //Mutability (upperNames is modified externally).
    for (String name : names) {
      upperNames.add(name.toUpperCase()); // BAD: Imperative style
    }

    //🟢 Why is this good?
    //✔ Declarative and concise.
    //✔ No mutability issues.
    List<String> upperNames2 = names
        .stream()
        .map(String::toUpperCase)
        .toList(); // Immutable List (Java 16+)


  }


  //🔴 Why is this bad?
  //Uses forEach() for transformation instead of map().
  //Breaks immutability by modifying emails externally.
  public List<String> getActiveUserEmails(List<User> users) {
    List<String> emails = new ArrayList<>();
    users.stream().filter(User::isActive)
        .forEach(user -> emails.add(user.getEmail())); // BAD: Mutating external state
    return emails;
  }

  //🟢 Why is this better?
  //✔ Avoids external mutation.
  //✔ More functional and readable.
  //✔ Immutable result (toList()).
  public List<String> getActiveUserEmailsCorrectWay(List<User> users) {
    return users.stream()
        .filter(User::isActive)
        .map(User::getEmail)
        .toList(); // Immutable List (Java 16+)
  }

  //🔴 Why is this bad?
  //Nested loops instead of declarative composition.
  //Modifies result externally (not functional).
  public List<Order> findHighValueOrders(List<Customer> customers) {
    List<Order> result = new ArrayList<>();
    for (Customer customer : customers) {
      for (Order order : customer.getOrders()) {
        if (order.getTotal() > 1000) {
          result.add(order); // BAD: Nested loops and external state mutation
        }
      }
    }
    return result;
  }

  //🟢 Why is this better?
  //✔ Eliminates nested loops using flatMap().
  //✔ Purely functional (no mutable external lists).
  //✔ More readable and declarative.
  public List<Order> findHighValueOrdersCorrectWay(List<Customer> customers) {
    return customers.stream()
        .map(Customer::getOrders)
        .flatMap(List::stream)
        .filter(order -> order.getTotal() > 1000)
        .toList();
  }

  //🔴 Why is this bad?
  //map() should be pure (no side effects).
  //Mixes data transformation with actions (bad FP practice).
  public List<String> processOrders(List<Order> orders) {
    return orders.stream()
        .map(order -> {
          order.sendNotification(); // BAD: `map()` should not cause side effects
          return order.getId();
        })
        .toList();
  }

  //🟢 Why is this better?
  //✔ Keeps map() pure (only transformations).
  //✔ Handles side effects in forEach() separately.
  //✔ Easier to test and debug.
  public List<String> processOrdersCorrectWay(List<Order> orders) {
    List<String> orderIds = orders.stream()
        .map(Order::getId)
        .toList(); // Extract IDs first

    orders.forEach(Order::sendNotification); // Side effects handled separately
    return orderIds;
  }
}