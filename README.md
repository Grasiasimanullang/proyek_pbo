# COOKIES IN YOUR HEART SYSTEM

Project ini merupakan program berbasis CLI (Command Line Interface) menggunakan bahasa Java untuk mengelola data penjualan pada usaha cookies bernama **COOKIES IN YOUR HEART**.

Program ini dibuat untuk memenuhi tugas mata kuliah **Pemrograman Berorientasi Objek (PBO)** dengan menerapkan konsep:

* OOP (Object Oriented Programming)
* Inheritance
* JDBC
* SQLite Database
* ORM sederhana menggunakan Data Mapper
* CLI System
* Table Output

---

# Fitur Program

Program memiliki beberapa fitur utama:

1. Menampilkan daftar menu cookies
2. Input pesanan pelanggan
3. Mendukung multi-order dalam satu transaksi
4. Harga otomatis sesuai menu
5. Menampilkan data penjualan dalam bentuk tabel
6. Hapus data berdasarkan ID
7. Hapus semua data sekaligus
8. Reset ID otomatis
9. Cetak struk pembelian
10. Export struk ke file `.txt`
11. Promo diskon otomatis 5%
12. Penyimpanan data menggunakan SQLite

---

# Daftar Menu Cookies

| No | Menu                      | Harga    |
| -- | ------------------------- | -------- |
| 1  | Chocolate Chip Cookies    | Rp15.000 |
| 2  | Oatmeal Raisin Cookies    | Rp18.000 |
| 3  | Double Chocolate Cookies  | Rp20.000 |
| 4  | Peanut Butter Cookies     | Rp19.000 |
| 5  | Red Velvet Cookies        | Rp22.000 |
| 6  | Matcha Cookies            | Rp23.000 |
| 7  | Choco Lava Cookies        | Rp25.000 |
| 8  | Almond Crispy Cookies     | Rp21.000 |
| 9  | Vanilla Butter Cookies    | Rp17.000 |
| 10 | Cookies and Cream Cookies | Rp24.000 |

---

# Struktur Project

```text
proyek_pbo/
│
├── src/
│   ├── app/
│   │   └── Main.java
│   │
│   ├── model/
│   │   ├── Cookies.java
│   │   └── Pembeli.java
│   │
│   ├── mapper/
│   │   └── PenjualanMapper.java
│   │
│   ├── service/
│   │   └── PenjualanService.java
│   │
│   ├── db/
│   │   ├── DBConnection.java
│   │   └── InitDB.java
│   │
│   └── util/
│       └── TablePrinter.java
│
├── database/
│   └── cookies.db
│
├── lib/
│   ├── sqlite-jdbc-3.45.3.0.jar
│   ├── slf4j-api-2.0.13.jar
│   └── slf4j-simple-2.0.13.jar
│
├── out/
│
├── README.md
└── Makefile
```

---

# Penjelasan Folder

| Folder    | Fungsi                      |
| --------- | --------------------------- |
| src       | Source code utama           |
| database  | Penyimpanan database SQLite |
| lib       | Library JDBC SQLite         |
| out       | Hasil compile `.class`      |
| README.md | Dokumentasi project         |

---

# Database

Program menggunakan:

* SQLite
* JDBC Driver
* Database file:

```text
database/cookies.db
```

---

# Konsep OOP yang Digunakan

## 1. Class dan Object

Contoh:

* Cookies
* Pembeli

---

## 2. Inheritance

Class model menggunakan konsep pewarisan untuk pengelolaan object.

---

## 3. Encapsulation

Data pada object disimpan menggunakan:

* private attribute
* getter
* setter

---

## 4. Data Mapper (ORM Sederhana)

Class:

```text
PenjualanMapper.java
```

digunakan sebagai penghubung antara:

* Java Object
* SQLite Database

---

# Fitur Diskon

Program memiliki promo otomatis:

| Kondisi                    | Diskon |
| -------------------------- | ------ |
| Total belanja >= Rp100.000 | 5%     |

Diskon otomatis tercetak pada struk.

---

# Contoh Output Struk

```text
============================================================
                 COOKIES IN YOUR HEART
============================================================
Nama Pelanggan : kaka
============================================================
No  Menu                         Qty      Harga    Total
------------------------------------------------------------
1   Chocolate Chip Cookies      2        15000    30000
2   Oatmeal Raisin Cookies      3        18000    54000
3   Double Chocolate Cookies    4        20000    80000
------------------------------------------------------------
Subtotal                                : Rp164000
Diskon 5%                               : Rp8200
Grand Total                             : Rp155800
============================================================
        TERIMA KASIH TELAH MEMBELI
                 COME AGAIN ❤️
============================================================
```

---


# Cara Kerja Program

## Input Pesanan

User menginput:

* Nama pelanggan
* Nomor antrian
* Nomor menu
* Jumlah pesanan

Harga otomatis menyesuaikan menu.

---

## Multi Order

Program mendukung:

* lebih dari satu pesanan
* jumlah berbeda tiap menu

dalam satu transaksi pelanggan.

---

# Library yang Digunakan

| Library      | Fungsi                 |
| ------------ | ---------------------- |
| sqlite-jdbc  | JDBC SQLite Driver     |
| slf4j-api    | Logging dependency     |
| slf4j-simple | Logging implementation |

---

# Author

Project dibuat untuk memenuhi tugas mata kuliah:
```text Pemrograman Berorientasi Objek (PBO) ```

dengan studi kasus:

```text COOKIES IN YOUR HEART SYSTEM ```

Anggota Kelompok:
1. Boy Harendy Simamora
2. Grasia Manullang
3. josep Marpaung
4. Suchia Nikah Panjaitan