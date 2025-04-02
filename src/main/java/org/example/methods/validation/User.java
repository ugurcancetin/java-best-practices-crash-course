package org.example.methods.validation;

public class User {

  private String name;
  private int age;

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // Parametre doğrulaması yapmayan metod
  public void updateProfile(String newName, int newAge) {
    this.name = newName;
    this.age = newAge;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
