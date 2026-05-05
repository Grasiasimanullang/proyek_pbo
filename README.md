# M01 Cookies Sales Management System - COOKIES COCOLIES

Pada tugas ini dikembangkan sebuah sistem sederhana untuk mengelola **data penjualan cookies** pada usaha **COOKIES COCOLIES**.

Sistem ini digunakan untuk mencatat data produk cookies serta transaksi penjualannya.

Setiap produk cookies memiliki:
- id produk
- nama cookies
- harga
- stok

Setiap transaksi penjualan memiliki:
- transaction id
- nama cookies
- jumlah pembelian
- total harga
- waktu transaksi

Sistem ini bertujuan untuk membantu pengelolaan penjualan agar lebih terstruktur dan mudah dipantau.

Semua kelas model harus ditempatkan pada package:

    cookies.model

Driver class harus ditempatkan pada package:

    cookies.driver

------------------------------------------------------------------------

# Task 01: Manage Cookies Products

Driver:

    cookies.driver.Driver1

Format input:

    add-product#<id>#<name>#<price>#<stock>

Program membaca input hingga:

    ---

Output:

    id|name|price|stock

### Contoh Input

    add-product#C01#Chocolate Chip Cookies#15000#10
    add-product#C02#Strawberry Cookies#12000#5
    ---

### Contoh Output

    C01|Chocolate Chip Cookies|15000.0|10
    C02|Strawberry Cookies|12000.0|5

------------------------------------------------------------------------

# Task 02: Sales Transaction

Driver:

    cookies.driver.Driver2

Format input:

    sell#<id>#<cookie_name>#<quantity>#<timestamp>

Aturan:
- stok akan berkurang sesuai jumlah pembelian
- jika stok tidak cukup, transaksi tidak diproses

### Contoh Input

    add-product#C01#Chocolate Chip Cookies#15000#10
    sell#T01#Chocolate Chip Cookies#2#2026/05/05 10:00:00
    ---

### Contoh Output

    C01|Chocolate Chip Cookies|15000.0|8

------------------------------------------------------------------------

# Task 03: Revenue Calculation

Driver:

    cookies.driver.Driver3

Sistem harus menghitung total pendapatan dari semua transaksi penjualan.

Output:

    Total Revenue: <value>

### Contoh Output

    Total Revenue: 30000.0

------------------------------------------------------------------------

# Task 04: Transaction History

Driver:

    cookies.driver.Driver4

Format tambahan:

    show-history

Output transaksi:

    transaction_id|cookie_name|quantity|total_price|timestamp

Transaksi harus diurutkan berdasarkan waktu (ascending).

------------------------------------------------------------------------

# How to Compile and Run

Compile:

    javac -cp "lib/*" src/*.java

Run:

    java -cp "lib/*;src" cookies.driver.Driver4

------------------------------------------------------------------------

# Submission

    src/cookies/model/*.java
    src/cookies/driver/Driver1.java
    src/cookies/driver/Driver2.java
    src/cookies/driver/Driver3.java
    src/cookies/driver/Driver4.java
    README.md