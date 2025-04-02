package org.example.optionals;

import java.util.Optional;

public class PoorOptionalExamples {

  private static Optional<String> email; // BAD: Optional should not be a field

  public static Optional<String> getEmail() {
    return email;
  }


  //🔴 Why is this bad?
  //get() throws NoSuchElementException if empty.
  //Defeats the purpose of Optional.
  public static void main(String[] args) {
    Optional<String> name = getEmail();
    System.out.println(name.get());

    //🔴 Why is this bad?
    //isPresent() + get() defeats the purpose of Optional.
    //Encourages null-like thinking instead of using Optional properly.
    Optional<String> email = getEmail();
    if (email.isPresent()) {
      sendEmail(email.get()); // BAD: Manual unwrapping
    }

  }

  private static void sendEmail(String email) {

  }
}
