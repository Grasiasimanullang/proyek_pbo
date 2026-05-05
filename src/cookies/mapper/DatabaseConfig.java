package cookies.mapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConfig {
    private static final String URL = "jdbc:sqlite:db/cookies.db";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS sales (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "buyer_name TEXT, queue_number TEXT, variant TEXT, flavor TEXT, " +
                     "qty INTEGER, price REAL, packaging TEXT, origin TEXT, type TEXT);";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception e) {
            System.err.println("Gagal inisialisasi DB: " + e.getMessage());
        }
    }
}
