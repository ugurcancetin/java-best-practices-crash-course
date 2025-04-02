package org.example.datatypes;

public class Boxing {

  public static void main(String[] args) {
    int iterations = 10_000_000;

    // 1. Primitive int kullanarak toplama
    long startTime = System.nanoTime();
    int sumPrimitive = 0;
    for (int i = 0; i < iterations; i++) {
      sumPrimitive += i;
    }
    long durationPrimitive = System.nanoTime() - startTime;
    System.out.println("Primitive int ile toplam: " + sumPrimitive);
    System.out.println("Süre (ms): " + (durationPrimitive / 1_000_000.0));

    // 2. Boxed Integer kullanarak toplama (autoboxing/unboxing işlemleri gerçekleşiyor)
    startTime = System.nanoTime();
    Integer sumBoxed = 0;
    for (int i = 0; i < iterations; i++) {
      sumBoxed += i; // Her yinelemede, Integer -> int unboxing, işlem sonrası int -> Integer autoboxing gerçekleşir.
    }
    long durationBoxed = System.nanoTime() - startTime;
    System.out.println("Boxed Integer ile toplam: " + sumBoxed);
    System.out.println("Süre (ms): " + (durationBoxed / 1_000_000.0));

  }

}
