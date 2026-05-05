package db;

import java.sql.Connection;
import java.sql.Statement;
import db.DBConnection;

public class InitDB {

    public static void createTable() {
        try {
            Connection conn = DBConnection.connect();
            Statement st = conn.createStatement();

            String sql = 
                    "CREATE TABLE IF NOT EXISTS penjualan (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nama_pembeli TEXT," +
                    "nomor_antrian INTEGER," +
                    "varian TEXT," +
                    "rasa TEXT," +
                    "jumlah INTEGER," +
                    "harga_satuan INTEGER," +
                    "packaging TEXT," +
                    "asal_pesanan TEXT" +
                    ")";
            ;

            st.execute(sql);

            System.out.println("✔ Tabel penjualan siap digunakan");

        } catch (Exception e) {
            System.out.println("❌ Error init DB: " + e.getMessage());
        }
    }
}