package util;

import db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TablePrinter {

    public static void print() {

        try {

            Connection conn = DBConnection.connect();

            Statement st =
                conn.createStatement();

            ResultSet rs =
                st.executeQuery("SELECT * FROM penjualan");

            System.out.println("=================================================================================================");

            System.out.printf("%-5s %-5s %-15s %-10s %-30s %-10s %-10s %-10s\n",
                    "No",
                    "ID",
                    "Nama",
                    "Antrian",
                    "Menu",
                    "Harga",
                    "Jumlah",
                    "Total");

            System.out.println("=================================================================================================");

            int no = 1;

            while (rs.next()) {

                System.out.printf("%-5d %-5d %-15s %-10d %-30s %-10d %-10d %-10d\n",
                        no++,
                        rs.getInt("id"),
                        rs.getString("nama_pelanggan"),
                        rs.getInt("nomor_antrian"),
                        rs.getString("nama_menu"),
                        rs.getInt("harga"),
                        rs.getInt("jumlah"),
                        rs.getInt("total")
                );
            }

            System.out.println("=================================================================================================");

        } catch (Exception e) {

            System.out.println("❌ Error tampil data: " + e.getMessage());
        }
    }
}