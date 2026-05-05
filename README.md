M01 Cookies In Your Heart Simulator
Pada tugas kali ini, Anda diminta untuk mengembangkan sebuah sistem manajemen penjualan cookies untuk perusahaan bernama COOKIES IN YOUR HEART. Sistem ini memungkinkan pegawai untuk mencatat data penjualan secara terstruktur dan menyimpannya secara permanen.

Setiap data penjualan memiliki informasi:

Nama pembeli

Nomor antrian

Varian cookies

Rasa

Jumlah (quantity) yang dibeli

Harga satuan

Pilihan packaging

Asal pesanan (GrabFood, GoFood, ShopeeFood, atau Datang ke Toko)

Untuk mendukung fleksibilitas, jenis penjualan harus direpresentasikan menggunakan konsep pewarisan (inheritance) dan disimpan ke database SQLite menggunakan pola Data Mapper (ORM).

Semua kelas model harus ditempatkan pada package:
cookies.model

Kelas mapper dan konfigurasi database pada package:
cookies.mapper

Driver class harus ditempatkan pada package:
cookies.driver

Task 01: Basic Sales Input (20 pts)
Driver yang dikembangkan:
cookies.driver.Driver1

Format masukan:
add-sale#<nama_pembeli>#<no_antrian>#<varian>#<rasa>#<qty>#<harga_satuan>#<packaging>#<asal_pesanan>

Program membaca masukan hingga:
---

Output (Format sederhana):
nama_pembeli|no_antrian|varian|qty|total_harga

Contoh Input
Plaintext
add-sale#Josef#001#Soft Cookies#Matcha#2#15000#Box#Datang ke Toko
add-sale#Christian#002#Crunchy#Choco#1#12000#Plastic#GrabFood
---
Output
Plaintext
Josef|001|Soft Cookies|2|30000.0
Christian|002|Crunchy|1|12000.0


Task 02: Inheritance & Business Logic (25 pts)
Tambahkan kelas abstrak Sale dan subclass berdasarkan Asal Pesanan:

OnlineSale (untuk GrabFood, GoFood, ShopeeFood)

InStoreSale (untuk Datang ke Toko)

Pada OnlineSale, terdapat biaya layanan tambahan sebesar Rp2.000 per transaksi yang ditambahkan ke total harga.

Driver:
cookies.driver.Driver2

Contoh Input
Plaintext
add-sale#Josef#001#Soft Cookies#Matcha#2#15000#Box#Datang ke Toko
add-sale#Christian#002#Crunchy#Choco#1#12000#Plastic#GrabFood
---
Output (Total harga Christian bertambah biaya layanan)
Plaintext
Josef|001|Soft Cookies|2|30000.0
Christian|002|Crunchy|1|14000.0


Task 03: SQLite & Data Mapper Persistence (25 pts)
Implementasikan penyimpanan data ke database SQLite (cookies.db). Gunakan pola Data Mapper sehingga kelas model tidak mengandung kode SQL.

Setiap kali perintah add-sale dijalankan, data harus langsung tersimpan di database menggunakan JDBC.

Driver:
cookies.driver.Driver3

Ketentuan:

Gunakan PreparedStatement untuk keamanan data.

Pastikan koneksi database dikelola di dalam package cookies.mapper.

Task 04: Structured Table Output & Exception (30 pts)
Driver:
cookies.driver.Driver4

Perintah tambahan:
show-sales

Format Output harus berupa tabel yang rapi dengan border. Selain itu, buatlah custom exception InvalidQuantityException yang dibangkitkan jika user memasukkan qty kurang dari atau sama dengan 0.

Contoh Output show-sales
Plaintext
====================================================================================================
| NO  | PEMBELI         | VARIAN       | RASA       | QTY | PKG     | ASAL         | TOTAL         |
====================================================================================================
| 001 | Josef           | Soft Cookies | Matcha     | 2   | Box     | Toko         | Rp30.000,00   |
| 002 | Christian       | Crunchy      | Choco      | 1   | Plastic | GrabFood     | Rp14.000,00   |
====================================================================================================
How to Compile and Run
Pastikan file sqlite-jdbc.jar berada di folder lib.

Compile:

Bash
javac -cp ".;lib/*" -d bin src/cookies/model/*.java src/cookies/mapper/*.java src/cookies/driver/*.java
Run:

Bash
java -cp "bin;lib/*" cookies.driver.Driver4