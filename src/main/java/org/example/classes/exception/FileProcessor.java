package org.example.classes.exception;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileProcessor {

  private static final Logger LOGGER = Logger.getLogger(FileProcessor.class.getName());

  public void processFile(String filePath) {
    FileService fileService = new FileService();
    try {
      List<String> lines = fileService.readFile(filePath); // Calls method that may throw
      System.out.println("File content: " + lines);
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Error reading file: " + filePath, e);
      System.out.println("Could not read file. Please check the file path and try again.");
    }
  }

  //try with resources is safe to use when working with resource as it closes automatically
  public static void writeMessage(String fromFilePath, String toFilePath) throws IOException {
    Path fromPath = Paths.get(fromFilePath);
    Path toPath = Paths.get(toFilePath);

    try (InputStream inputStream = Files.newInputStream(fromPath);
        OutputStream outputStream = Files.newOutputStream(toPath)) {
        //write the logic
    }
  }
}
