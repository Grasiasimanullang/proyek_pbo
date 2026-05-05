package util;

import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TablePrinter {

    public static void print() {
        try {
            Connection conn = DBConnection.connect();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM penjualan");

            System.out.println("====================================================================================");
            System.out.printf("%-3s %-15s %-5s %-10s %-10s %-5s %-10s %-10s %-10s%n",
                    "ID", "Nama", "No", "Varian", "Rasa", "Jml", "Harga", "Pack", "Asal");
            System.out.println("====================================================================================");

            while (rs.next()) {
                System.out.printf("%-3d %-15s %-5d %-10s %-10s %-5d %-10d %-10s %-10s%n",
                        rs.getInt("id"),
                        rs.getString("nama_pembeli"),
                        rs.getInt("nomor_antrian"),
                        rs.getString("varian"),
                        rs.getString("rasa"),
                        rs.getInt("jumlah"),
                        rs.getInt("harga_satuan"),
                        rs.getString("packaging"),
                        rs.getString("asal_pesanan")
                );
            }

        } catch (Exception e) {
            System.out.println("❌ Error print table: " + e.getMessage());
        }
    }
}