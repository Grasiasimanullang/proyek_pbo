package mapper;

import db.DBConnection;
import model.Cookies;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PenjualanMapper {

    public void insert(Cookies c) {
        try {
            Connection conn = DBConnection.connect();

            String sql = "INSERT INTO penjualan " +
        "(nama_pembeli, nomor_antrian, varian, rasa, jumlah, harga_satuan, packaging, asal_pesanan) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, c.getNamaPembeli());
            ps.setInt(2, c.getNomorAntrian());
            ps.setString(3, c.getVarian());
            ps.setString(4, c.getRasa());
            ps.setInt(5, c.getJumlah());
            ps.setInt(6, c.getHargaSatuan());
            ps.setString(7, c.getPackaging());
            ps.setString(8, c.getAsalPesanan());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("❌ Error insert: " + e.getMessage());
        }
    }
}