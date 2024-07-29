# Garanti Yönetim Sistemi

Bu proje başta IoT nesneleri olmak üzere çeşitli ürünlerin garanti sürelerini basitçe takip edebilmek için geliştirilmiştir. <br>

# Proje Detayları
- Projede `MVC` yazılım mimarisi kullanılmıştır.<br>
- UI kısmında kolaylık olması için veri erişim noktasında direkt varlıklarımızı kullanmak yerine `DTO - (Data Transfer Object)` varlıkları kullanılmıştır.<br>
- Proje dosya mimarisi:<br>
- <img src="https://github.com/user-attachments/assets/b8564eb9-33dc-46f4-b9d8-8d5074c187f4"/>



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
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/eece8133-2517-455f-a209-1b29d2037c5f"/><br><br>
    <strong>state: </strong>fail<br>
    <img src="https://github.com/user-attachments/assets/294103bf-079d-4083-9aff-d64e24a3f410"/><br>
  </details>
  <details>
    <summary><h3>GET - Get All Devices</h3></summary>
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/1c05022a-6f9c-4168-9ddd-047b3da414af"/><br><br>
  </details>
  <details>
    <summary><h3>GET - Get Device by Id</h3></summary>
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/e8432a50-e9c6-4e4a-a6e1-05f9d5e33092"/><br><br>
  </details>
  <details>
    <summary><h3>GET - Get Device by Serial Number</h3></summary>
    <strong>state: </strong>success<br>
    <strong>url: </strong>Kok_url/serialNumber={id}<br>
    <img src="https://github.com/user-attachments/assets/457a059c-fc5c-40d1-bfaf-34db5fd98f2e"/><br><br>
  </details>
  <details>
    <summary><h3>PUT - Update Device by Id</h3></summary>
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/d10e6e06-9801-4c83-9a62-85724f852ffc"/><br><br>
  </details>
  <details>
    <summary><h3>PUT - Update Device by Serial Number</h3></summary>
    <strong>state: </strong>success<br>
    <strong>url: </strong>Kok_url/serialNumber={id}<br>
    <img src="https://github.com/user-attachments/assets/54664b91-8fd9-4a0a-ae71-5c74f8c2d26b"/><br><br>
  </details>
  <details>
    <summary><h3>DELETE - Delete Device by Id</h3></summary>
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/93e37465-442c-41c0-a1b8-f90733bbefc0"/><br><br>
  </details>
  <details>
    <summary><h3>DELETE - Delete Device by Serial Number</h3></summary>
    <strong>state: </strong>success<br>
    <strong>url: </strong>Kok_url/serialNumber={id}<br>
    <img src="https://github.com/user-attachments/assets/e938162e-3bcc-4be8-9318-4639482664ac"/><br><br>
  </details>
</details>
<details>
  <summary><h2>Garanti İşlemleri</h2></summary>
  <strong>url: </strong>Kok_url/warranties<br>
  <details>
    <summary><h3>POST - Add Warranty</h3></summary>
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/8317dcc7-a59c-4658-b5b2-0a90051f2831"/><br><br>
    <strong>state: </strong>fail<br>
    <img src="https://github.com/user-attachments/assets/bb8a83bb-e76b-43b8-98fa-403bd76a4b0c"/><br>
    <img src="https://github.com/user-attachments/assets/39f8702e-5d86-4571-a4e3-23d4c4ee79c2"/><br>
  </details>
  <details>
    <summary><h3>GET - Get All Warranties</h3></summary>
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/8ac99b0f-f311-4313-afed-30d8938dcc3b"/><br>
  </details>
  <details>
    <summary><h3>GET - Get Warranty By Id</h3></summary>
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/61b1410a-cd9b-458c-b922-05dc5c36dbc7"/><br>
  </details>
  <details>
    <summary><h3>GET - Get Warranty By Device Id</h3></summary>
    <strong>state: </strong>success<br>
    <strong>url: </strong>Kok_url/deviceId={id}<br>
    <img src="https://github.com/user-attachments/assets/147aad93-b449-4878-9d0c-3f87de0879f6"/><br>
  </details>
  <details>
    <summary><h3>PUT - Update Warranty By Id</h3></summary>
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/c23bfa70-d940-4bca-84e4-81de1666e871"/><br>
  </details>
  <details>
    <summary><h3>PUT - Update Warranty By Device Id</h3></summary>
    <strong>state: </strong>success<br>
    <strong>url: </strong>Kok_url/deviceId={id}<br>
    <img src="https://github.com/user-attachments/assets/0f12b179-150e-480f-bce5-d66fb00afe94"/><br>
  </details>
  <details>
    <summary><h3>DELETE - Delete Warranty By Id</h3></summary>
    <strong>state: </strong>success<br>
    <img src="https://github.com/user-attachments/assets/e3a762ee-5916-417c-8c52-40a57f1e07f5"/><br>
  </details>
  <details>
    <summary><h3>DELETE - Delete Warranty By Device Id</h3></summary>
    <strong>state: </strong>success<br>
    <strong>url: </strong>Kok_url/deviceId={id}<br>
    <img src="https://github.com/user-attachments/assets/2303697f-b87a-4eab-a1f0-33c2367299fb"/><br>
  </details>
</details>
