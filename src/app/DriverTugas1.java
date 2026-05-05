package app;

import model.Cookies;
import service.PenjualanService;

import java.util.Scanner;

public class DriverTugas1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PenjualanService service = new PenjualanService();

        System.out.println("=== INPUT PENJUALAN COOKIES ===");

        System.out.print("Nama Pembeli: ");
        String nama = sc.nextLine();

        System.out.print("Nomor Antrian: ");
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
        String packaging = sc.nextLine();

        System.out.print("Asal Pesanan (Grab/GoFood/ShoppeeFood/Offline): ");
        String asal = sc.nextLine();

        Cookies c = new Cookies(nama, antrian, varian, rasa, jumlah, harga, packaging, asal);

        service.tambah(c);

        System.out.println("\n✔ Data berhasil disimpan!");
    }
}