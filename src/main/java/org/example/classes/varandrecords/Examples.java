package org.example.classes.varandrecords;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

//Use records for small immutable classes, not for everything as it's not flexible. Use Lombok or proper POJO for more flexibility.
record User(UUID usurId, String username) {

}

public class Examples {

  public static void main(String[] args) {
    var list = List.of(); // wrong - inferred as List<Object>
    var list2 = List.of("Hello"); // correct

    var set = new HashSet<>(); // wrong = same problem
    Set<String> mySet = new HashSet<>(); // correct


  }

}
