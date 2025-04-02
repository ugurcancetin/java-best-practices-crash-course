# Methods Best Practices
Her örnek için sebep sonuç ilişkisini burada bulabilirsiniz. Anlamadığınız yer olursa, önce araştırın sonra bana ulaşın 🤓

## İçindekiler
* [CQS](#CQS)
* [Parameter Validation](#parameter-validation)
* [Method Signature](#method-signature)


### CQS

CQS (Command Query Separation) prensibi, bir metodun ya bir şey yapmasını (komut) ya da bir şey döndürmesini (sorgu) önerir. Ancak, ikisini birden yapmaması gerekir.

#### Faydaları:
- ✅ Kodun okunaklılığını ve bakımını kolaylaştırır.
- ✅ Yan etkileri azaltarak hata ayıklamayı kolaylaştırır.
- ✅ Test yazmayı daha basit hale getirir.

#### Dezavantajları:
- ⚠️ Küçük projelerde fazla katı olması kod tekrarına neden olabilir.
- ⚠️ Fazladan metod çağırmak performansı az da olsa etkileyebilir.

CQS, özellikle büyük ve karmaşık projelerde kodun sürdürülebilirliğini artıran bir prensiptir! 🚀

### Parameter Validation

Parametre doğrulama eksik olduğunda, metod beklenmedik girişler alabilir ve hatalara yol açabilir.

#### ✅ Faydaları:

- Hataların erken tespit edilmesini sağlar.
- Kodun güvenilirliğini artırır.
- Kullanıcı hatalarından kaynaklanan beklenmeyen hataları önler.

#### ⚠️ Dezavantajları:

- Fazladan kod yazmayı gerektirir.
- Performans açısından küçük bir ek yük oluşturabilir (ancak genellikle ihmal edilebilir düzeyde).
- Parametre doğrulaması, özellikle büyük ve dış girişlere (API'ler, kullanıcı girişleri) bağlı projelerde kritik bir öneme sahiptir! 🚀

### Method Signature

Kötü method imzaları hem kodu okunması zor bir hale getirir, hem de istenmeyen sonuçlara yol açar. Bunun yanı sıra üzerinde çalıştığımız projeler büyürken yeni yazılan kodlar projenin sağlığı açısından inanılmaz bir önem taşır. 

#### Faydaları:

✅ 1. Okunabilirliği Artırır

* Açık ve anlamlı metod isimleri sayesinde, kodu okuyan biri ne yapıldığını hemen anlar.
* Gereksiz yorum satırlarına ihtiyaç duyulmaz.

✅ 2. Bakımı ve Genişletmeyi Kolaylaştırır

* Anlamlı metod ve parametre isimleri, yeni bir geliştiricinin veya gelecekteki sizin için kodu anlamayı kolaylaştırır.
* Yeni özellikler eklemek daha az hata riski taşır.

✅ 3. Hata Yapma Riskini Azaltır

* İyi tanımlanmış parametreler ve input doğrulamaları, yanlış veri girişini önler.
* Daha az hata, daha stabil bir uygulama sağlar.

✅ 4. Test Yazmayı Kolaylaştırır

* Tek bir sorumluluğa sahip metodlar (SRP prensibi) daha iyi test edilebilir.
* Küçük ve bağımsız metodlar, birim testlerin daha hızlı ve anlaşılır olmasını sağlar.

✅ 5. Kodun Yeniden Kullanılabilirliğini Artırır

* Genel ve iyi tasarlanmış metod imzaları, farklı yerlerde tekrar tekrar kullanılabilir.
* Aynı kodu kopyalamak yerine, metod çağırarak kullanmak mümkün olur.

✅ 6. Anlamlı API ve Arayüzler Sunar

* Eğer metodlar dışarıya açık bir API veya kütüphane içinde kullanılacaksa, temiz metod imzaları kullanıcı deneyimini iyileştirir.
* Açık ve net bir API dokümantasyona duyulan ihtiyacı azaltır.