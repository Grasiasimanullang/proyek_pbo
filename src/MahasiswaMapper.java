import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaMapper {

    public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();

        String sql = "SELECT * FROM mahasiswa";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mahasiswa m = new Mahasiswa(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("jurusan")
                );
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔥 METHOD INSERT HARUS DI DALAM CLASS
    public void insert(Mahasiswa m) {
        String sql = "INSERT INTO mahasiswa(nama, jurusan) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, m.getNama());
            pstmt.setString(2, m.getJurusan());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}