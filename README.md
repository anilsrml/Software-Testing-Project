# REST Assured API Regression Test Framework

## 1. Proje Açıklaması
Bu proje, `https://jsonplaceholder.typicode.com` servisi üzerinde GET, POST ve DELETE senaryolarını kapsayan REST API regresyon test otomasyon projesidir.
Amaç; API cevaplarının status code, response body ve response time kontrollerini otomatik olarak doğrulamaktır.

## 2. Kullanılan Teknolojiler
- Java 17
- Maven
- JUnit 5
- Rest Assured
- Hamcrest
- Jackson Databind
- Maven Surefire Plugin

## 3. Kurulum Adımları
1. Java 17 ve Maven kurulu olduğundan emin olun.
2. Projeyi klonlayın:
   ```bash
   git clone <repo-url>
   ```
3. Proje dizinine geçin:
   ```bash
   cd RestAssuredTestProject
   ```
4. Bağımlılıkları indirin ve varsayılan testleri çalıştırın:
   ```bash
   mvn test
   ```

## 4. Test Çalıştırma Komutları
```bash
# Functional regression (varsayılan)
mvn test

# Performance/SLA testleri (build fail etmeden raporlar)
mvn test -Pperformance
```

`mvn test` komutu varsayılan olarak `functional` etiketli testleri çalıştırır. Bu testlerde API'nin doğru status code ve beklenen response body değerlerini döndürüp döndürmediği kontrol edilir.

`mvn test -Pperformance` komutu `performance` profilini aktif eder. Bu profil ile GET, POST ve DELETE isteklerinin belirlenen süre limitleri içinde cevap verip vermediği doğrulanır.

## 5. Test Kapsamı
- `GET /posts/1`: Mevcut bir post kaydının başarıyla döndüğünü kontrol eder.
- `POST /posts`: Request body ile yeni post oluşturma senaryosunu kontrol eder.
- `DELETE /posts/1`: Silme isteğinin başarılı response döndürdüğünü kontrol eder.

## 6. Tag Stratejisi
- `@Tag("functional")`: status code + body doğrulamaları
- `@Tag("performance")`: response-time (SLA) doğrulamaları

Varsayılan çalıştırma functional testleri koşar. `performance` profili sadece SLA testlerini çalıştırır ve sonuçları raporlar.

## 7. Örnek Test Çıktısı
```text
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## 8. Framework Mimarisi Açıklaması
```text
project-root/
├── src/test/java
│   ├── base
│   │   └── BaseTest.java       # Base URI ve ortak RequestSpecification yönetimi
│   ├── models
│   │   └── PostRequest.java    # POST request body POJO modeli
│   ├── tests
│   │   ├── GetTests.java       # GET functional + SLA testleri
│   │   ├── PostTests.java      # POST functional + SLA testleri
│   │   └── DeleteTests.java    # DELETE functional + SLA testleri
│   └── utils
│       └── TestData.java       # Endpoint, SLA ve test verileri
├── src/test/resources
├── pom.xml
├── README.md
└── .gitignore
```

### Mimari Prensipler
- **Merkezi yapılandırma:** Base URI ve ortak request ayarları `BaseTest` içinde yönetilir.
- **Tekrarı azaltma:** Endpoint, response-time limitleri ve request data `TestData` üzerinden tekrar kullanılabilir.
- **Açık sorumluluk ayrımı:** Model, test ve altyapı katmanları ayrıştırılmıştır.
- **Okunabilir assertionlar:** Given-When-Then akışı ve Hamcrest matcher'ları ile net doğrulama sağlanır.
