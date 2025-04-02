package org.example.classes.immutability;

import java.util.List;

public class PoorUserProfile {

  private String name;
  private List<String> roles;

  public PoorUserProfile(String name, List<String> roles) {
    this.name = name;
    this.roles = roles; // Mutable reference!
  }

  public List<String> getRoles() {
    return roles; // Directly exposing mutable list!
  }
}
