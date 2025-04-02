package org.example.datatypes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Precision {

  public static void main(String[] args) {
    // Örnek: Bir ürünün fiyatına %7,5 KDV eklenmesi

    // double kullanılarak hesaplama
    double fiyat = 19.99;
    double kdvOrani = 0.075; // %7,5 KDV
    double kdv = fiyat * kdvOrani;
    double toplamDouble = fiyat + kdv;
    System.out.println("double ile hesaplanan toplam fiyat: " + toplamDouble);
    // Burada beklenen değer: 19.99 + 1.49925 = 21.48925,
    // fakat double hesaplamalarında küçük yuvarlama hataları oluşabilir.

    // BigDecimal kullanılarak hesaplama
    // BigDecimal oluşturulurken kesin değeri sağlamak için String kullanmak önemlidir.
    BigDecimal fiyatBD = new BigDecimal("19.99");
    BigDecimal kdvOraniBD = new BigDecimal("0.075");
    BigDecimal kdvBD = fiyatBD.multiply(kdvOraniBD);
    // KDV genellikle 2 ondalık basamakla hesaplanır, bu nedenle yuvarlama yapmamız gerekir.
    kdvBD = kdvBD.setScale(2, RoundingMode.HALF_UP);
    BigDecimal toplamBD = fiyatBD.add(kdvBD);
    System.out.println("BigDecimal ile hesaplanan toplam fiyat: " + toplamBD);
    // Çıktı: 21.49 (tam olarak doğru hesaplanır)

    //---------------------------------------------------------------------------------------
    System.out.println("--------------------------------------------------------------------");
    // double kullanarak hesaplama
    double bakiyeDouble = 0.0;
    double yatirmaDouble = 0.1;
    for (int i = 0; i < 10; i++) {
      bakiyeDouble += yatirmaDouble;
    }
    System.out.println("double ile hesaplanan bakiye: " + bakiyeDouble);
    // Beklenen sonuç 1.0 olsa da double hesaplamalarda 0.9999999999999999 gibi bir değer çıkabilir.

    // BigDecimal kullanarak hesaplama
    BigDecimal bakiyeBD = new BigDecimal("0.0");
    BigDecimal yatirmaBD = new BigDecimal("0.1");
    for (int i = 0; i < 10; i++) {
      bakiyeBD = bakiyeBD.add(yatirmaBD);
    }
    System.out.println("BigDecimal ile hesaplanan bakiye: " + bakiyeBD);
    // Çıktı tam olarak: 1.0
  }

}
