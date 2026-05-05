package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("✔ SQLite Driver loaded");
        } catch (Exception e) {
            System.out.println("❌ Driver gagal load: " + e.getMessage());
        }
    }

    public static Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                "jdbc:sqlite:database/cookies.db"
            );

        } catch (Exception e) {
            System.out.println("❌ Koneksi gagal: " + e.getMessage());
        }

        return conn;
    }
}