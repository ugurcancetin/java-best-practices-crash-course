package org.example.classes.exception;

import java.nio.file.Files;
import java.nio.file.Path;

public class PoorExceptionHandling {

  public void readFile(String filePath) {
    try {
      Files.readAllLines(Path.of(filePath));
    } catch (Exception e) {  // Catches unrelated exceptions (e.g., OutOfMemoryError, NullPointerException).
      System.out.println("An error occurred!");
    }
  }
}
