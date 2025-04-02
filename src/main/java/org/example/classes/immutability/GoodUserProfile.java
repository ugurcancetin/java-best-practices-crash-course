package org.example.classes.immutability;

import java.util.Collections;
import java.util.List;

public class GoodUserProfile {

  private final String name;
  private final List<String> roles;

  public GoodUserProfile(String name, List<String> roles) {
    this.name = name;
    this.roles = List.copyOf(roles); // Defensive copy
  }

  public String getName() {
    return name;
  }

  public List<String> getRoles() {
    return Collections.unmodifiableList(roles);
  }
}
