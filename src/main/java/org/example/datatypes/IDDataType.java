package org.example.datatypes;

import java.util.UUID;

public class IDDataType {

  public static void main(String[] args) {
    // Örneğin, kullanıcı ID'si "00123" olmalı, ancak int kullanıldığında bu 123 olarak saklanır.
    WrongUser user = new WrongUser(123, "Ali");
    System.out.println(user);

    User user2 = new User("Veli");
    System.out.println(user2);
  }
}

class WrongUser {

  // Hatalı kullanım: ID'yi int olarak tanımlamak.
  // Örneğin, "00123" gibi bir ID girildiğinde, int olarak 123'e dönüşür.
  private int id;
  private String name;

  public WrongUser(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "WrongUser{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  public static void main(String[] args) {
    // Örneğin, kullanıcı ID'si "00123" olmalı, ancak int kullanıldığında bu 123 olarak saklanır.
    WrongUser user = new WrongUser(123, "Ali");
    System.out.println(user);
  }
}


class User {

  // Doğru kullanım: ID'yi UUID olarak tanımlamak,
  // böylece global olarak benzersiz ve formatı bozulmamış bir ID elde edilir.
  private final UUID id;
  private String name;

  public User(String name) {
    // Kullanıcı oluşturulduğunda benzersiz bir ID atanır.
    this.id = UUID.randomUUID();
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  public static void main(String[] args) {
    User user = new User("Ayşe");
    System.out.println(user);
  }
}
