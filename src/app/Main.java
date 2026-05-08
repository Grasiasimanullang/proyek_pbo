package app;

import db.InitDB;
import java.util.Scanner;
import model.Cookies;
import service.PenjualanService;
import util.TablePrinter;

public class Main {

    static String[] menuNama = {
        "Chocolate Chip Cookies",
        "Oatmeal Raisin Cookies",
        "Double Chocolate Cookies",
        "Peanut Butter Cookies",
        "Red Velvet Cookies",
        "Matcha Cookies",
        "Choco Lava Cookies",
        "Almond Crispy Cookies",
        "Vanilla Butter Cookies",
        "Cookies and Cream Cookies"
    };

    static int[] menuHarga = {
        15000,
        18000,
        20000,
        19000,
        22000,
        23000,
        25000,
        21000,
        17000,
        24000
    };

    // =========================
    // TAMPIL MENU
    // =========================
    public static void tampilMenuCookies() {

        System.out.println("==============================================");
        System.out.println("              DAFTAR MENU COOKIES             ");
        System.out.println("==============================================");

        for (int i = 0; i < menuNama.length; i++) {

            System.out.printf("%d. %s = Rp%,d\n",
                    i + 1,
                    menuNama[i],
                    menuHarga[i]);
        }

        System.out.println("==============================================");
    }

    // =========================
    // MAIN PROGRAM
    // =========================
    public static void main(String[] args) {

        InitDB.createTable();

        Scanner sc = new Scanner(System.in);

        PenjualanService service =
            new PenjualanService();

        while (true) {

            System.out.println("\n====================================================");
            System.out.println("           COOKIES IN YOUR HEART SYSTEM");
            System.out.println("====================================================");
            System.out.println("1. Menu");
            System.out.println("2. Input Pesanan");
            System.out.println("3. Lihat Data Penjualan");
            System.out.println("4. Hapus Data");
            System.out.println("5. Hapus Semua Data");
            System.out.println("6. Cetak Struk");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");

            int pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {

                // =========================
                // MENU
                // =========================
                case 1:

                    tampilMenuCookies();
                    break;

                // =========================
                // INPUT PESANAN
                // =========================
                case 2:

                    tampilMenuCookies();

                    System.out.print("Nama Pelanggan: ");
                    String nama = sc.nextLine();

                    System.out.print("No Antrian: ");
                    int antrian = sc.nextInt();

                    int grandTotal = 0;

                    while (true) {

                        System.out.print("Nomor Menu: ");
                        int nomorMenu = sc.nextInt();

                        System.out.print("Jumlah: ");
                        int jumlah = sc.nextInt();

                        String namaMenu =
                            menuNama[nomorMenu - 1];

                        int harga =
                            menuHarga[nomorMenu - 1];

                        int total =
                            harga * jumlah;

                        grandTotal += total;

                        Cookies c = new Cookies(
                                nama,
                                antrian,
                                namaMenu,
                                harga,
                                jumlah,
                                total
                        );

                        service.tambah(c);

                        System.out.println("✔ Pesanan ditambahkan!");

                        System.out.print("Tambah pesanan lagi? (y/n): ");

                        sc.nextLine();

                        String lagi =
                            sc.nextLine();

                        if (lagi.equalsIgnoreCase("n")) {

                            break;
                        }
                    }

                    System.out.println("====================================");
                    System.out.println("TOTAL SELURUH PESANAN = Rp" + grandTotal);
                    System.out.println("====================================");

                    break;

                // =========================
                // LIHAT DATA
                // =========================
                case 3:

                    TablePrinter.print();
                    break;

                // =========================
                // HAPUS DATA
                // =========================
                case 4:

                    System.out.print("Masukkan ID yang ingin dihapus: ");

                    int id = sc.nextInt();

                    service.delete(id);

                    break;

                // =========================
                // HAPUS SEMUA DATA
                // =========================
                case 5:

                    System.out.print("Yakin ingin hapus semua data? (y/n): ");

                    String konfirmasi =
                        sc.nextLine();

                    if (konfirmasi.equalsIgnoreCase("y")) {

                        service.deleteAll();
                    }

                    break;

                // =========================
                // CETAK STRUK
                // =========================
                case 6:

                    System.out.print("Nama Pelanggan: ");

                    String namaStruk =
                        sc.nextLine();

                    service.cetakStruk(namaStruk);

                    break;

                // =========================
                // KELUAR
                // =========================
                case 7:

                    sc.close();

                    System.out.println("Program selesai...");
                    return;

                // =========================
                // DEFAULT
                // =========================
                default:

                    System.out.println("❌ Menu tidak valid!");
            }
        }
    }
}