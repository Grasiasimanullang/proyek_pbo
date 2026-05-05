package app;

import java.util.Scanner;
import service.PenjualanService;

public class DriverTugas4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PenjualanService service = new PenjualanService();

        System.out.print("Nama pembeli: ");
        String nama = sc.nextLine();

        service.searchByNama(nama);
        service.cetakStruk(nama);
    }
}