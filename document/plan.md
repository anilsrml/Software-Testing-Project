# Yazılım Test Mühendisliği Proje Planı (Rest Assured)

## Problem ve Yaklaşım
Bu ödevde Java + Maven + JUnit + Rest Assured kullanarak bir servis için otomatik regresyon test projesi hazırlanmalı, çalıştırılarak sunulmalı ve GitHub'da paylaşılmalıdır. Zorunlu olarak en az bir çağrıda **status code**, **response body**, **yanıt süresi** kontrolü yapılmalı; ideal olarak en az bir **GET** ve bir **POST** testi yazılmalı, bunlardan en az birinde request body kullanılmalıdır.

Yaklaşım: Projeyi katmanlı ve sürdürülebilir bir test otomasyon yapısında kurup (config, client, test data, test sınıfları, raporlama), minimum gereksinimleri hızlıca sağlayan çekirdek senaryolarla başlayıp ardından regresyon kapsamını genişletmek.

## TODO Listesi
1. **project-bootstrap**
   - Maven projesini test otomasyonu için hazırla.
   - `rest-assured`, `junit-jupiter`, `maven-surefire`, opsiyonel `allure`/`surefire-report` bağımlılıklarını ekle.
   - Java sürümünü ortamla uyumlu ve stabil bir seviyeye çek (gerekirse LTS).

2. **framework-structure**
   - Temel paket yapısını oluştur: `config`, `client`, `model` (opsiyonel), `tests`, `utils`.
   - Base test ve ortak request specification yapısını hazırla (base URI, headers, logging).

3. **get-scenario-core**
   - En az bir GET testi yaz.
   - Doğrulamalar: status code, response body alan(lar)ı, response time threshold.

4. **post-scenario-core**
   - Request body (JSON/XML) kullanan en az bir POST testi yaz.
   - Doğrulamalar: status code, response body alan(lar)ı, response time threshold.

5. **test-data-management**
   - Test verilerini sabit/factory yaklaşımıyla merkezileştir.
   - Tekrarlı payload ve assertion alanlarını reusable hale getir.

6. **negative-and-regression-pack**
   - Minimum 2-3 negatif/kenar durum senaryosu ekle (örn. invalid payload, not found, auth yoksa 401 vb.).
   - Testleri smoke/regression olarak gruplandır (tag/annotation).

7. **reporting-and-run-guide**
   - Maven ile tek komutta test çalıştırma akışını netleştir.
   - Raporlama çıktısını (Surefire/Allure) üret ve README'de kullanımını yaz.

8. **ci-pipeline**
   - GitHub Actions ile otomatik test çalıştırma workflow’u ekle.
   - Push/PR tetiklerinde testlerin otomatik koşmasını sağla.

9. **presentation-deliverables**
   - “Yapay zeka destekli yazılım test mühendisliği” sunumunu hazırla.
   - Demo akışını hazırla: kod yapısı, test yazımı, test çalıştırma, sonuçların yorumlanması.
   - Sunum dosyasını repo’ya yükle ve public repo URL’sini paylaşılabilir hale getir.

## Notlar / Kararlar
- Servis seçimi: Kendi API’niz yoksa hızlı başlangıç için herkese açık test API’leri (örn. ReqRes / JSONPlaceholder) kullanılabilir.
- Yanıt süresi eşiği: Ortama göre gerçekçi bir limit belirlenmeli (örn. `< 2000ms`) ve flaky sonuçları azaltacak şekilde seçilmeli.
- Assertion stratejisi: Kritik alanlar için net ve deterministic kontroller tercih edilmeli.
- Değerlendirme açısından en kritik çıktı: Çalışan testler + anlaşılır proje yapısı + sunum + public GitHub repo.
