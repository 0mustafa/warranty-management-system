# Garanti Takip Sistemi

Bu proje başta IoT nesneleri olmak üzere çeşitli ürünlerin garanti sürelerini basitçe takip edebilmek için geliştirilmiştir. <br>

# Proje Detayları
- Projede `MVC` yazılım mimarisi kullanılmıştır.<br>
- UI kısmında kolaylık olması için veri erişim noktasında direkt varlıklarımızı kullanmak yerine `DTO - (Data Transfer Object)` varlıkları kullanılmıştır.<br>
- Proje dosya mimarisi:<br>
- <img src="https://github.com/user-attachments/assets/670c7c2e-5acc-445f-b5b7-661088afeecd"/>



# Proje Modelleri
- Device
  - id (Long)
  - serialNumber (String)
  - brand (String)
  - model (String)
- Warranty
  - id (Long)
  - deviceId (Long)
  - purchaseDate (LocalDate)
  - warrantyStatus (String)

# API'ın Sağladığı İstekler
<strong>Kok_url:</strong> http://localhost:8080/api
<details>
  <summary><h2>Cihaz İşlemleri</h2></summary>
  <strong>url: </strong>Kok_url/devices<br>
  <details>
    <summary><h3>POST - Add Device</h3></summary>
    <strong>Durum: </strong>Başarılı<br>
    <strong>Açıklama: </strong>Ekleme işlemi başarılı.<br>
    <img src="https://github.com/user-attachments/assets/24a31f85-c4a4-4082-aa36-f059bb217b64"/><br><br>
    <strong>Durum: </strong>başarısız<br>
    <strong>Açıklama: </strong>Cihazın seri numarası girilmemiş.<br>
    <img src="https://github.com/user-attachments/assets/bf08653c-20e5-4ace-9c1f-ed3b547ce3d7"/><br><br>
    <strong>Durum: </strong>başarısız<br>
    <strong>Açıklama: </strong>Cihazın satın alma tarihi girilmemiş.<br>
    <img src="https://github.com/user-attachments/assets/86a50db8-60d3-41ca-9108-9867d95c1864"/><br><br>
    <strong>Durum: </strong>başarısız<br>
    <strong>Açıklama: </strong>Cihazın satın alma tarihi yanlış girilmiş.<br>
    <img src="https://github.com/user-attachments/assets/172e04b3-20f0-421b-b826-37f8d44636ef"/><br><br>
  </details>
  
  <details>
    <summary><h3>GET - Get All Devices</h3></summary>
    <strong>Durum: </strong>Başarılı<br>
    <strong>Açıklama: </strong>Tüm cihazlar getirildi.<br>
    <img src="https://github.com/user-attachments/assets/a7551c06-2db0-4932-b9ad-8ace617be9de"/><br><br>
  </details>
  
  <details>
    <summary><h3>GET - Get Device by Id</h3></summary>
    <strong>Durum: </strong>Başarılı<br>
    <strong>Açıklama: </strong>Girilen id numarasına sahip cihaz getirildi.<br>
    <img src="https://github.com/user-attachments/assets/897e1cbd-648b-4d53-9137-af54991e393d"/><br><br>
    <strong>Durum: </strong>Başarısız<br>
    <strong>Açıklama: </strong>Girilen id numarasına sahip cihaz bulunmamaktadır.<br>
    <img src="https://github.com/user-attachments/assets/b9d6d849-a73f-4577-a9c1-729c9d6e1d03"/><br><br>
  </details>
  
  <details>
    <summary><h3>GET - Get Device by Serial Number</h3></summary>
    <strong>Url: </strong>Kok_url/serialNumber={id}<br><br>
    <strong>Durum: </strong>Başarılı<br>
    <strong>Açıklama: </strong>Girilen seri numarasına sahip cihaz getirildi.<br>
    <img src="https://github.com/user-attachments/assets/84ac2b3d-866e-49fc-86ae-aeba8ee63fae"/><br><br>
    <strong>Durum: </strong>success<br>
    <strong>Açıklama: </strong>Girilen seri numarasına sahip cihaz bulunmamaktadır.<br>
    <img src="https://github.com/user-attachments/assets/665e0e2d-8afc-4aec-ba62-5829d2ca9578"/><br><br>
  </details>
  
  <details>
    <summary><h3>PUT - Check All Warranties</h3></summary>
    <strong>Durum: </strong>Başarılı<br>
    <strong>Açıklama: </strong>Sistemdeki tüm cihazların garanti durumları kontrol edildi.<br>
    <img src="https://github.com/user-attachments/assets/1daceddd-49f2-4dd9-8618-8702f1559527"/><br><br>
  </details>
  
  <details>
    <summary><h3>PUT - Update Device by Id</h3></summary>
    <strong>Durum: </strong>Başarılı<br>
    <strong>Açıklama: </strong>Girilen id numarasına sahip cihaz güncellendi.<br>
    <img src="https://github.com/user-attachments/assets/84d7a9f6-f5c1-4a62-851e-ab3c1c1e1c24"/><br><br>
    <strong>Durum: </strong>Başarısız<br>
    <strong>Açıklama: </strong>Güncellenmek istenen cihazın satın alma tarihi boş bırakılmış.<br>
    <img src="https://github.com/user-attachments/assets/9d9d17cc-3296-470e-8a20-fa8b9ea7c9ce"/><br><br>
    <strong>Durum: </strong>Başarısız<br>
    <strong>Açıklama: </strong>Güncellenmek istenen cihazın satın alma tarihi yanlış biçimde girilmiş.<br>
    <img src="https://github.com/user-attachments/assets/d65af81a-24a0-48c1-9a34-038a4cf7fbae"/><br><br>
  </details>
  
  <details>
    <summary><h3>PUT - Update Device by Serial Number</h3></summary>
    <strong>Url: </strong>Kok_url/serialNumber={id}<br><br><br>
    <strong>Durum: </strong>Başarılı<br>
    <strong>Açıklama: </strong>Girilen seri numarasına  sahip cihaz güncellendi.<br>
    <img src="https://github.com/user-attachments/assets/5270af2d-2797-4808-90be-237f132b937d"/><br><br>
    <strong>Durum: </strong>Başarısız<br>
    <strong>Açıklama: </strong>Güncellenmek istenen cihazın satın alma tarihi boş bırakılmış.<br>
    <img src="https://github.com/user-attachments/assets/6f6903dd-edf7-4819-a7ba-1fb88d7347a8"/><br><br>
    <strong>Durum: </strong>Başarısız<br>
    <strong>Açıklama: </strong>Güncellenmek istenen cihazın satın alma tarihi yanlış biçimde girilmiş.<br>
    <img src="https://github.com/user-attachments/assets/4f4b34f0-9a04-4391-ab92-c8b754199f79"/><br><br>
  </details>
  
  <details>
    <summary><h3>DELETE - Delete Device by Id</h3></summary>
    <strong>Durum: </strong>Başarılı<br>
    <strong>Açıklama: </strong>Girilen id numarasına sahip cihaz silindi.<br>
    <img src="https://github.com/user-attachments/assets/a4c7f31b-12e8-496b-84f2-a901cbc23f06"/><br><br>
    <strong>Durum: </strong>Başarısız<br>
    <strong>Açıklama: </strong>Girilen id numarasına sahip bir cihaz bulunmamaktadır.<br>
    <img src="https://github.com/user-attachments/assets/e4f51667-b790-4a16-8255-9f355585d000"/><br><br>
  </details>
  
  <details>
    <summary><h3>DELETE - Delete Device by Serial Number</h3></summary>
    <strong>Url: </strong>Kok_url/serialNumber={id}<br><br>
    <strong>Durum: </strong>Başarılı<br>
    <strong>Açıklama: </strong>Girilen seri numarasına sahip cihaz silindi.<br>
    <img src="https://github.com/user-attachments/assets/ea927941-8ab6-408e-9c46-6eac2ef114b8"/><br><br>
    <strong>Durum: </strong>Başarısız<br>
    <strong>Açıklama: </strong>Girilen seri numarasına sahip bir cihaz bulunmamaktadır.<br>
    <img src="https://github.com/user-attachments/assets/de2f5581-b1c0-4519-b09a-075267ba7f99"/><br><br>
  </details>
</details>
