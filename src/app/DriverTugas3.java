package app;

import java.util.Scanner;
import service.PenjualanService;

public class DriverTugas3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PenjualanService service = new PenjualanService();

        System.out.println("1. Update Jumlah");
        System.out.println("2. Delete Data");
        System.out.print("Pilih: ");

        int pilih = sc.nextInt();

        if (pilih == 1) {
            System.out.print("ID: ");
            int id = sc.nextInt();

            System.out.print("Jumlah baru: ");
            int jumlah = sc.nextInt();

            service.updateJumlah(id, jumlah);

        } else if (pilih == 2) {
            System.out.print("ID: ");
            int id = sc.nextInt();

            service.delete(id);
        }
    }
}