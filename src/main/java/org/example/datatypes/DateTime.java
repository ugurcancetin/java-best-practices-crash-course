package org.example.datatypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTime {

  public static void main(String[] args) throws ParseException {
    // --- Eski API Kullanımı ---
    // 1. java.util.Date
    Date oldDate = new Date();
    System.out.println("Eski Date: " + oldDate);

    // 2. java.util.Calendar
    Calendar calendar = Calendar.getInstance();
    // Dikkat: Aylar 0'dan başlar (Ocak = 0)
    System.out.println("Eski Calendar (ay dikkat!): " + calendar.getTime());

    // --- Yeni API Kullanımı (java.time) ---
    System.out.println("========== Yeni API Kullanımı (java.time) ========== ");
    // 1. LocalDate: Sadece tarih (yıl-ay-gün)
    LocalDate localDate = LocalDate.now();
    System.out.println("LocalDate: " + localDate);

    // 2. LocalTime: Sadece zaman (saat-dakika-saniye)
    LocalTime localTime = LocalTime.now();
    System.out.println("LocalTime: " + localTime);

    // 3. LocalDateTime: Tarih ve zaman (mutlaka aynı yerel ayarda)
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println("LocalDateTime: " + localDateTime);

    // 4. ZonedDateTime: Tarih, zaman ve zaman dilimi bilgisi
    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println("ZonedDateTime (varsayılan zaman dilimi): " + zonedDateTime);

    // 5. Belirli bir zaman dilimiyle ZonedDateTime örneği
    ZonedDateTime parisTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
    System.out.println("ZonedDateTime (Paris): " + parisTime);

    // 6. DateTimeFormatter ile formatlama
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String formattedDateTime = localDateTime.format(formatter);
    System.out.println("Formatlanmış LocalDateTime: " + formattedDateTime);

    System.out.println("========== Eski ve Yeni API ==========  ");
    System.out.println("=== Eski API Örneği (java.util.Date, Calendar) ===");
    oldApiExample();

    System.out.println("\n=== Yeni API Örneği (java.time) ===");
    newApiExample();


  }

  /**
   * Eski API kullanılarak:
   * - SimpleDateFormat ile tarih string'ini parse etme
   * - Calendar kullanarak tarih üzerinde işlem yapma (1 gün ekleme)
   *
   * Notlar:
   * 1. SimpleDateFormat thread-safe değildir.
   * 2. Calendar nesnesi mutable (değiştirilebilir) olduğu için, aynı nesne üzerinde birden fazla işlem yapılırken yan etkiler oluşabilir.
   * 3. Ay bilgisi 0-indexed tutulur (Ocak=0, Şubat=1, Mart=2, ...), bu da kafa karışıklığına yol açar.
   */
  public static void oldApiExample() throws ParseException {
    String dateStr = "2021-03-14 23:30:00";

    // SimpleDateFormat kullanarak tarih parse ediliyor.
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // Zaman dilimi ayarı: America/New_York
    sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    Date date = sdf.parse(dateStr);
    System.out.println("Parsed Date: " + sdf.format(date));

    // Calendar kullanarak tarih işlemi yapma
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
    calendar.setTime(date);

    // Dikkat: Aylar 0-indexed! (Mart ayı için 2 dönecektir: Ocak=0, Şubat=1, Mart=2)
    int month = calendar.get(Calendar.MONTH);
    System.out.println("Month (0-indexed): " + month);

    // 1 gün ekleme işlemi
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    Date nextDay = calendar.getTime();
    System.out.println("Next Day: " + sdf.format(nextDay));
  }

  /**
   * Yeni API kullanılarak:
   * - DateTimeFormatter ile tarih string'inin parse edilmesi
   * - LocalDateTime ve ZonedDateTime kullanılarak tarih üzerinde işlem yapılması (1 gün ekleme)
   *
   * Avantajlar:
   * 1. Yeni API immutable olduğu için yapılan işlemler yan etki oluşturmaz.
   * 2. API, metod isimleri ve sınıf ayrımları ile daha okunabilir ve hataya kapalı bir yapı sunar.
   * 3. Zaman dilimleri ve formatlama işlemleri daha doğal ve anlaşılırdır.
   */
  public static void newApiExample() {
    String dateStr = "2021-03-14 23:30:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // LocalDateTime ile parse işlemi (zaman dilimi bilgisi olmadan)
    LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);

    // ZonedDateTime oluşturma: Zaman dilimini belirterek.
    ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("America/New_York"));
    System.out.println("Parsed Date: " + zonedDateTime.format(formatter));

    // 1 gün ekleme işlemi (plusDays metodu kullanılarak)
    ZonedDateTime nextDay = zonedDateTime.plusDays(1);
    System.out.println("Next Day: " + nextDay.format(formatter));
  }

}
