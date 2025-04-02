package org.example.classes.exception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


//✅ Use Checked Exceptions for recoverable conditions (e.g., file not found, database failure).
//✅ Use Unchecked Exceptions for programming logic errors (e.g., invalid input, null pointer).
//✅ Never catch generic Exception or Throwable unless absolutely necessary.
//✅ Create meaningful custom exceptions with clear naming.
//✅ Always include the root cause (Throwable cause) in custom exceptions for debugging.
public class GoodExceptionHandling {

  public void readFile(String filePath) {
    try {
      Files.readAllLines(Path.of(filePath));
    } catch (IOException e) { // Handles only expected errors (IOException).
      System.err.println("File read failed: " + e.getMessage());
    }
  }
}
