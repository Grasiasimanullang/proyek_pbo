// FILE: src/db/InitDB.java

package db;

import java.sql.Connection;
import java.sql.Statement;

public class InitDB {

    public static void createTable() {

        try {

            Connection conn = DBConnection.connect();
            Statement st = conn.createStatement();

            String sql =
                "CREATE TABLE IF NOT EXISTS penjualan (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nama_pelanggan TEXT," +
                "nomor_antrian INTEGER," +
                "nama_menu TEXT," +
                "harga INTEGER," +
                "jumlah INTEGER," +
                "total INTEGER" +
                ")";

            st.execute(sql);

            System.out.println("✔ Tabel penjualan siap digunakan");

        } catch (Exception e) {

            System.out.println("❌ Error init DB: " + e.getMessage());
        }
    }
}