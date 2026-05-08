# REST Assured API Regression Test Framework

## 1. Proje Açıklaması
Bu proje, `https://jsonplaceholder.typicode.com` servisi üzerinde GET ve POST senaryolarını kapsayan profesyonel seviyede bir REST API regression test otomasyon framework'üdür.  
Amaç; ölçeklenebilir, okunabilir ve merkezi yönetilen bir test mimarisi ile hızlı geri bildirim sağlamaktır.

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
4. Bağımlılıkları indirin ve testleri çalıştırın:
   ```bash
   mvn clean test
   ```

## 4. Test Çalıştırma Komutu
```bash
mvn clean test
```

## 5. Örnek Test Çıktısı
```text
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## 6. Framework Mimarisi Açıklaması
```text
project-root/
├── src/test/java
│   ├── base
│   │   └── BaseTest.java       # Base URI ve ortak RequestSpecification yönetimi
│   ├── models
│   │   └── PostRequest.java    # POST request body POJO modeli
│   ├── tests
│   │   ├── GetTests.java       # GET /posts/1 doğrulamaları
│   │   └── PostTests.java      # POST /posts doğrulamaları
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
