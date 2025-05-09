# 📦 Katalon IFG Testing Project

Project ini merupakan kumpulan automated test berbasis [Katalon Studio](https://www.katalon.com/) untuk pengujian fitur API dan integrasi Kafka pada sistem IFG.

---

## 📁 Struktur Direktori
```
.
└── Project/
├── API/
│ ├── tc01_valid_login
│ ├── tc02_invalid_login
│ ├── tc03_get_user_profile
│ ├── tc04_add_new_product
│ └── tc05_delete_product
├── Kafka/
│ └── test_kafka
└── Object Repository/
├── AddProduct
├── DeleteProduct
├── LoginRequest
└── SearchUser
```
yaml
Copy
Edit

---

## ✅ API Test Cases

Semua pengujian API dilakukan menggunakan fitur **Web Service Testing** di Katalon Studio:

| Test Case                  | Deskripsi                                 |
|----------------------------|-------------------------------------------|
| `tc01_valid_login`          | Valid login dengan kredensial benar       |
| `tc02_invalid_login`        | Gagal login dengan kredensial salah       |
| `tc03_get_user_profile`     | Mendapatkan profil pengguna yang login    |
| `tc04_add_new_product`      | Menambahkan produk baru                   |
| `tc05_delete_product`       | Menghapus produk yang ada                 |

---

## 🔄 Kafka Integration

- `test_kafka`: Menjalankan simulasi konsumsi Kafka message menggunakan setup container Docker.

---

## 🛠️ Setup Kafka (Docker)

### 1. Install Docker Desktop  
Unduh dan pasang Docker dari: [https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop)

### 2. Masuk ke Direktori Kafka  
```bash
cd Project/Kafka
3. Jalankan Kafka
Jika file bernama kafka_setup.yml, gunakan:

bash
Copy
Edit
docker-compose -f kafka_setup.yml up -d
Jika file sudah bernama docker-compose.yml, cukup:

bash
Copy
Edit
docker-compose up -d
```
4. Cek Container
bash
Copy
Edit
docker ps
```

###5. Hentikan Kafka dan Zookeeper
bash
Copy
Edit
docker-compose down
▶️ Menjalankan Tes di Katalon Studio
Buka Katalon Studio

Load folder project

Di tab Test Explorer, klik kanan salah satu test case

Pilih Run untuk menjalankan tes

Lihat hasil di tab Log Viewer atau Reports

🧰 Tools & Teknologi
Katalon Studio

Docker & Docker Compose

Apache Kafka

Groovy (scripting Katalon)

REST API

👩‍💻 Kontributor
liandasari17
