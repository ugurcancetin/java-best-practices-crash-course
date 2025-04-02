package org.example.datatypes;

public class ConcatPerformance {

  public static void main(String[] args) {
    int iterations = 50000; // İşlem sayısı

    // Normal String concatenation kullanarak birleştirme
    long startTime = System.nanoTime();
    String normalConcat = "";
    for (int i = 0; i < iterations; i++) {
      normalConcat += i;
    }
    long durationNormal = System.nanoTime() - startTime;
    double durationNormalMs = durationNormal / 1_000_000.0; // Nanosecond -> Milisaniye

    System.out.println("Normal String concatenation süresi: " + durationNormalMs + " ms");

    // StringBuilder kullanarak birleştirme
    startTime = System.nanoTime();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < iterations; i++) {
      sb.append(i);
    }
    long durationBuilder = System.nanoTime() - startTime;
    double durationBuilderMs = durationBuilder / 1_000_000.0; // Nanosecond -> Milisaniye

    System.out.println("StringBuilder ile concatenation süresi: " + durationBuilderMs + " ms");
  }
}
