# Data Types Best Practices

Her örnek için sebep sonuç ilişkisini burada bulabilirsiniz. Anlamadığınız yer olursa, önce araştırın sonra bana ulaşın 🤓

## İçindekiler

* [Precision](#precision)
* [Concat Performance](#concat-performance)
* [Boxing](#boxing)
* [Date](#date)



# Precision

Double ve float veri tiplerinin arkasındaki temel sebep, bu veri tiplerinin IEEE 754 standardına uygun olarak ikili kayan nokta (binary floating point) gösterimi kullanmasıdır. Bu gösterim, sayıları ikili (binary) sistemde ifade eder ve bu durum bazı ondalık kesirlerin tam olarak temsil edilememesine yol açar. İşte bu durumun nedenleri:

Temsildeki Sınırlama:

- Ondalık (decimal) sistemde basit görünen 0.1, ikili sistemde sonsuz dönemli (tekrarlayan) bir dizi olarak temsil edilir.
Bilgisayar belleğinde sayılar sınırlı bit sayısı (örneğin, double için 64 bit, float için 32 bit) ile saklandığından, bu sayı tam olarak temsil edilemez ve yakınsama (approximation) yapılır.
Yuvarlama Hataları:

- İkili kayan nokta temsili, hesaplamalar sırasında aritmetik işlemlerde ufak yuvarlama hatalarına neden olur.
Özellikle toplama, çıkarma, çarpma gibi işlemlerde bu küçük hatalar birikerek beklenmeyen sonuçlar doğurabilir.
Finansal Hesaplamalar İçin Uygun Olmaması:

- Para hesaplamalarında hassasiyet çok önemlidir. Küçük yuvarlama hataları büyük farklara neden olabilir.
Bu nedenle, kesin hesaplama gerektiren durumlarda BigDecimal gibi sınıflar tercih edilir. BigDecimal, sayıların tam ondalık (decimal) temsiline yakın çalışır ve yuvarlama hatalarını minimize eder.
### Özetle:
Double ve float, sayıları hızlı ve bellek verimli şekilde işleyebilmek için tasarlanmıştır, ancak bu da bazı durumlarda (özellikle finansal hesaplamalar gibi hassas işlemlerde) istenmeyen küçük hataların ortaya çıkmasına neden olur. Bu yüzden bu tür durumlarda BigDecimal kullanılarak kesin hesaplamalar yapılır.

# Concat Performance

- Normal String Concatenation:
Her += işlemi, mevcut String ile yeni eklenen değeri birleştirir ve yeni bir String nesnesi oluşturur. Bu durum, özellikle büyük döngülerde performans kaybına ve fazla bellek kullanımına neden olur.

- StringBuilder:
StringBuilder, tek bir nesne üzerinde çalışır ve her ekleme (append()) mevcut nesneye yeni veriyi ekler. Bu sayede gereksiz nesne oluşturma işlemleri ortadan kalkar ve performans önemli ölçüde artar.

Çalıştırdığınızda, normal String concatenation'ın StringBuilder'a göre çok daha yavaş çalıştığını gözlemleyeceksiniz. Bu nedenle, özellikle yoğun string işlemleri yapılan durumlarda StringBuilder kullanılması önerilir.

# Boxing

Java'da temel veri tipleri (primitive types) ile onların sarmalayıcı (boxed) tipleri (örneğin, int vs. Integer) arasında performans ve bellek kullanımı gibi açılardan önemli farklar bulunmaktadır. Mümkün olduğunca primitive tipler tercih edilmelidir. İşte bu konunun nedenlerini ve nasıl uygulandığını açıklayan detaylar:

## Neden Primitive Tipler Tercih Edilmeli?

1. Bellek ve Performans:

- Primitive Tipler: Java'da int, double, boolean gibi primitive tipler, doğrudan değerleri saklar. Bu nedenle, bellek kullanımları çok daha verimlidir ve işlemler hızlı gerçekleşir.
- Boxed Tipler: Integer, Double, Boolean gibi boxed tipler nesne olarak saklanır. Nesne oluşturma, referans yönetimi ve otomatik kutulama (autoboxing) / kutudan çıkarma (unboxing) işlemleri ek yük getirir. Bu durum, özellikle yoğun döngülerde performans kaybına neden olabilir.

2. Otomatik Kutulama ve Unboxing:

- Java, primitive tipler ile boxed tipler arasında otomatik dönüşüm (autoboxing/unboxing) yapar. Ancak bu otomatik işlemler ek işlem maliyeti getirir. 
- Örneğin, bir Integer üzerinde matematiksel işlem yaparken Java önce nesneyi primitive int'e çevirir (unboxing), sonra işlemi gerçekleştirir ve sonucu tekrar Integer nesnesine dönüştürür (autoboxing). Bu, özellikle büyük veri setlerinde ekstra maliyet oluşturur.

3. Null Değer Riski:

- Primitive Tipler: Primitive tipler her zaman bir değer taşır (örneğin, int için varsayılan değer 0’dır) ve null olamazlar.
- Boxed Tipler: Bir boxed tip nesnesi null olabilir. Bu durum, özellikle hesaplama yaparken beklenmedik NullPointerException hatalarına yol açabilir.


# Date

Java'da tarih ve zaman işlemleri, yıllar boyunca çeşitli zorluklar ve karmaşıklıklar barındırmıştır. Eski API'ler (örneğin, java.util.Date ve java.util.Calendar) kullanılırken karşılaşılan başlıca sorunlar ve Java 8 ile gelen yeni java.time API'sinin bu sorunlara nasıl çözüm sunduğunu aşağıda kod örnekleri ve açıklamalarla inceleyelim.

## Eski API'lerin Zorlukları
1. Mutability (Değiştirilebilirlik):
- Date ve Calendar nesneleri değiştirilebilir (mutable) olduğundan, çoklu iş parçacığı (thread) ortamlarında senkronizasyon sorunlarına yol açabilir.
- Örneğin, aynı Calendar nesnesi birden fazla yerde değiştirilirse beklenmeyen sonuçlar ortaya çıkabilir.

2. Anlaşılması Zor Tasarım:

- Date sınıfı, tarih ve zaman bilgilerini tutmasına rağmen, üzerinde yapılacak işlemler için yetersiz metodlar sunar.
- Calendar ise daha fazla esneklik sunsa da ayları 0’dan başlatması gibi kafa karıştırıcı detaylar içerir (Ocak ayı 0, Aralık ayı 11 olarak tutulur).

3. Zaman Dilimi ve Yerel Ayarlar:

- Eski API'ler, zaman dilimleri ve yerel ayarlarla çalışırken beklenmedik davranışlara sebep olabilir.

3. Sınırlı İşlevsellik:

- Tarih hesaplamaları, formatlama ve dönüştürme gibi işlemler eski API’lerle oldukça karmaşık ve hataya açık hale gelebilir.

## Java 8 ve Yeni java.time API'si
Java 8 ile birlikte gelen java.time paketi, Joda-Time kütüphanesinden esinlenerek tasarlanmıştır. Bu yeni API'nin temel avantajları:

* Immutable (Değiştirilemezlik):
Tüm sınıflar (örneğin, LocalDate, LocalTime, LocalDateTime, ZonedDateTime) immutable’dır. Yani bir kez oluşturulduktan sonra nesne değiştirilemez; her işlem yeni bir nesne döndürür. Bu durum, thread-safe (iş parçacığı güvenli) çalışmayı sağlar.


* Daha Anlaşılır ve Zengin API:
Tarih ve zaman işlemleri için çok daha zengin metodlar ve operatörler sunar. Örneğin, zaman dilimleriyle çalışmak, tarih hesaplamaları yapmak ve formatlama işlemleri daha basit hale gelir.


* Net ve Açık Tasarım:
API, tarih, zaman, tarih-zaman ve zaman dilimi gibi kavramları ayrı sınıflarla yöneterek daha açık ve bakımı kolay bir yapı sunar.



