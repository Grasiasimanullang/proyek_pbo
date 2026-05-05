package app;

import java.util.Scanner;

import model.Cookies;
import service.PenjualanService;
import util.TablePrinter;
import db.InitDB;

public class Main {

    public static void main(String[] args) {

        InitDB.createTable();
        
        Scanner sc = new Scanner(System.in);
        PenjualanService service = new PenjualanService();

        while (true) {

            System.out.println("\n==========================================");
            System.out.println("    COOKIES IN YOUR HEART SYSTEM    ");
            System.out.println("==========================================");
            System.out.println("1. Input Penjualan");
            System.out.println("2. Lihat Data Penjualan");
            System.out.println("3. Update Jumlah");
            System.out.println("4. Hapus Data");
            System.out.println("5. Cari Pembeli");
            System.out.println("6. Cetak Struk");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {

                // =====================
                // INPUT
                // =====================
                case 1: {
                    System.out.print("Nama Pembeli: ");
                    String nama = sc.nextLine();

                    System.out.print("No Antrian: ");
                    int antrian = sc.nextInt(); sc.nextLine();

                    System.out.print("Varian: ");
                    String varian = sc.nextLine();

                    System.out.print("Rasa: ");
                    String rasa = sc.nextLine();

                    System.out.print("Jumlah: ");
                    int jumlah = sc.nextInt();

                    System.out.print("Harga Satuan: ");
                    int harga = sc.nextInt(); sc.nextLine();

                    System.out.print("Packaging: ");
                    String pack = sc.nextLine();

                    System.out.print("Asal Pesanan: ");
                    String asal = sc.nextLine();

                    Cookies c = new Cookies(nama, antrian, varian, rasa, jumlah, harga, pack, asal);

                    service.tambah(c);

                    System.out.println("✔ Data berhasil disimpan!");
                    break;
                }

                // =====================
                // VIEW
                // =====================
                case 2: {
                    TablePrinter.print();
                    break;
                }

                // =====================
                // UPDATE
                // =====================
                case 3: {
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    System.out.print("Jumlah baru: ");
                    int jumlah = sc.nextInt();

                    service.updateJumlah(id, jumlah);
                    break;
                }

                // =====================
                // DELETE
                // =====================
                case 4: {
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    service.delete(id);
                    break;
                }

                // =====================
                // SEARCH
                // =====================
                case 5: {
                    System.out.print("Nama pembeli: ");
                    String nama = sc.nextLine();

                    service.searchByNama(nama);
                    break;
                }

                // =====================
                // STRUK
                // =====================
                case 6: {
                    System.out.print("Nama pembeli: ");
                    String nama = sc.nextLine();

                    service.cetakStruk(nama);
                    break;
                }

                // =====================
                // EXIT
                // =====================
                case 7: {
                    System.out.println("Keluar...");
                    return;
                }

                default: {
                    System.out.println("Menu tidak valid!");
                }
            }
        }
    }
}