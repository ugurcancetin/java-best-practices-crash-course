package org.example.methods.validation;

public class ValidUser {

  private String name;
  private int age;

  public ValidUser(String name, int age) {
    validateName(name);
    validateAge(age);
    this.name = name;
    this.age = age;
  }

  // Parametre doğrulaması yapan metod
  public void updateProfile(String newName, int newAge) {
    validateName(newName);
    validateAge(newAge);
    this.name = newName;
    this.age = newAge;
  }

  private void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
  }

  private void validateAge(int age) {
    if (age < 0 || age > 120) {
      throw new IllegalArgumentException("Age must be between 0 and 120");
    }
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
