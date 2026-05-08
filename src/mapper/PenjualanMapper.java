// FILE: src/mapper/PenjualanMapper.java

package mapper;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Cookies;

public class PenjualanMapper {

    public void insert(Cookies c) {

        try {

            Connection conn = DBConnection.connect();

            String sql =
                "INSERT INTO penjualan " +
                "(nama_pelanggan, nomor_antrian, nama_menu, harga, jumlah, total) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, c.getNamaPelanggan());
            ps.setInt(2, c.getNomorAntrian());
            ps.setString(3, c.getNamaMenu());
            ps.setInt(4, c.getHarga());
            ps.setInt(5, c.getJumlah());
            ps.setInt(6, c.getTotal());

            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("❌ Error insert: " + e.getMessage());
        }
    }
}