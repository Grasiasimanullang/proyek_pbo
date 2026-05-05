M01 COOKIES IN YOUR HEART - PBO PROJECT

Pada tugas ini anda diminta untuk mengembangkan sebuah sistem penjualan cookies berbasis CLI (Command Line Interface) menggunakan Java.

Sistem ini mensimulasikan aplikasi kasir sederhana yang memungkinkan pegawai untuk mencatat transaksi penjualan cookies secara terstruktur.

Setiap transaksi memiliki informasi:

nama pembeli
nomor antrian
varian cookies
rasa
jumlah pembelian
harga satuan
packaging
asal pesanan (GrabFood / GoFood / ShopeeFood / Datang ke toko)

Sistem ini menggunakan:

JDBC (SQLite Database)
Inheritance
Data Mapper Pattern (ORM sederhana)
Modular Architecture (Service, Model, Mapper, DB Layer)
📦 Package Structure

Semua kelas model berada pada package:

src.model

Semua logic utama berada pada:

src.service
src.mapper
src.db
src.util
src.app


TASK 01: INPUT & BASIC CRUD SYSTEM 

Driver:

app.DriverTugas1

Format Input:
Input data penjualan secara manual:
- nama pembeli
- nomor antrian
- varian
- rasa
- jumlah
- harga satuan
- packaging
- asal pesanan

Data disimpan ke SQLite database.

Output:
✔ Data berhasil disimpan!
Contoh Input:
Nama Pembeli: Sari
No Antrian: 12
Varian: Crumble
Rasa: Coklat
Jumlah: 2
Harga Satuan: 20000
Packaging: Kotak
Asal Pesanan: GrabFood


TASK 02: VIEW DATA PENJUALAN

Driver:

app.DriverTugas2
Fitur:
Menampilkan seluruh data penjualan
Output dalam bentuk tabel CLI
Output Format:
ID | Nama | Varian | Rasa | Jumlah | Harga | Total


TASK 03: UPDATE & DELETE DATA 

Driver:

app.DriverTugas3
Fitur:
Update jumlah pembelian berdasarkan ID
Delete data berdasarkan ID
Validasi data sebelum eksekusi
Contoh Input:
Update Jumlah:
ID: 1
Jumlah Baru: 5

Delete:
ID: 2


TASK 04: SEARCH & STRUK + EXPORT FILE 

Driver:

app.DriverTugas4
Fitur:
Cari data berdasarkan nama pembeli
Cetak struk pembelian
Export struk ke file .txt
Menampilkan total harga transaksi
Format Struk:
======================================
         STRUK PEMBELIAN
   COOKIES IN YOUR HEART
======================================
Nama     : Sari
Varian   : Crumble
Rasa     : Coklat
Jumlah   : 2
Harga    : 20000
Subtotal : 40000
--------------------------------------
GRAND TOTAL: 40000
======================================
🧱 DATABASE STRUCTURE (SQLite)

Tabel: penjualan

Field	Type
id	INTEGER (PK)
nama_pembeli	TEXT
nomor_antrian	INTEGER
varian	TEXT
rasa	TEXT
jumlah	INTEGER
harga_satuan	INTEGER
packaging	TEXT
asal_pesanan	TEXT
⚙️ HOW TO RUN PROJECT
Compile:
javac -cp ".;lib/*" -d out src/app/*.java src/model/*.java src/service/*.java src/mapper/*.java src/db/*.java src/util/*.java
Run:
java -cp ".;out;lib/*" app.Main
🧠 SOFTWARE DESIGN
✔ Object Oriented Programming
Encapsulation
Inheritance
Polymorphism
✔ Architecture
Service Layer Pattern
Data Mapper Pattern (ORM sederhana)
MVC-like separation
✔ Database
SQLite via JDBC
Auto table initialization