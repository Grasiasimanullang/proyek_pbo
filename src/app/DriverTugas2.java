package app;

import service.PenjualanService;
import util.TablePrinter;

public class DriverTugas2 {
    public static void main(String[] args) {

        PenjualanService service = new PenjualanService();

        System.out.println("=== DATA PENJUALAN ===");

        TablePrinter.print();
    }
}