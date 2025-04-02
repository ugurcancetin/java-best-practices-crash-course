package org.example.methods.signatures;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GoodMethodSignatures {

  //Why it's good: This method uses generics to create a flexible and reusable filtering method that can work with any type.
  public <T> List<T> filter(List<T> items, Predicate<T> predicate) {
    return items.stream().filter(predicate).collect(Collectors.toList());
  }

  //Why it's good: This method uses a functional interface (Consumer) to process items, making the method more flexible and promoting the use of lambda expressions.
  public void processItems(List<String> items, Consumer<String> processor) {
    items.forEach(processor);
  }

  //Why it's good: This method uses Java Streams to process data efficiently, grouping items by category and counting them.
  public Map<String, Long> countItemsByCategory(List<Item> items) {
    return items.stream()
        .collect(Collectors.groupingBy(Item::getCategory, Collectors.counting()));
  }

//  Why it's good: Using Optional helps to avoid NullPointerException and makes it clear that the result might be absent.
//  public Optional<User> findUserById(String userId) {
//    User user = userRepository.findById(userId);
//    return Optional.ofNullable(user);
//  }

//  Why it's good: The @Cacheable annotation helps to cache the results of the method, improving performance by reducing the need for repeated database queries.
//  @Cacheable("users")
//  public User getUserDetails(String userId) {
//    return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
//  }

}

//Why it's good: This method signature supports method chaining, which can make the code more readable and expressive.
class QueryBuilder {

  private String query;

  public QueryBuilder select(String fields) {
    this.query = "SELECT " + fields;
    return this;
  }

  public QueryBuilder from(String table) {
    this.query += " FROM " + table;
    return this;
  }

  public QueryBuilder where(String condition) {
    this.query += " WHERE " + condition;
    return this;
  }

  public String build() {
    return this.query;
  }
}

class Item {

  String getCategory() {
    return "";
  }
}