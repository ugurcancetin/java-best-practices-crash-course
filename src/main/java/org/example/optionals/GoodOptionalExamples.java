package org.example.optionals;

import java.util.Optional;

public class GoodOptionalExamples {

  private static String email; // GOOD: Keep it as a normal field

  public static Optional<String> getEmail() {
    return Optional.ofNullable(email); // Return Optional safely
  }

  public void main(String[] args) {
    Optional<String> name = getEmail();
    System.out.println(name.orElse("Default Name"));

    getEmail().ifPresent(this::sendEmail);
  }

  private void sendEmail(String email) {

  }
}
