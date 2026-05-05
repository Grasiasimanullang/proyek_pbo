package service;

import mapper.PenjualanMapper;
import model.Cookies;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class PenjualanService {

    private PenjualanMapper mapper = new PenjualanMapper();

    // =====================
    // CREATE
    // =====================
    public void tambah(Cookies c) {
        mapper.insert(c);
    }

    // =====================
    // UPDATE
    // =====================
    public void updateJumlah(int id, int jumlahBaru) {
        try {
            Connection conn = DBConnection.connect();

            String sql = "UPDATE penjualan SET jumlah = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, jumlahBaru);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("✔ Data berhasil diupdate");

        } catch (Exception e) {
            System.out.println("❌ Error update: " + e.getMessage());
        }
    }

    // =====================
    // DELETE
    // =====================
    public void delete(int id) {
        try {
            Connection conn = DBConnection.connect();

            String sql = "DELETE FROM penjualan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("✔ Data berhasil dihapus");

        } catch (Exception e) {
            System.out.println("❌ Error delete: " + e.getMessage());
        }
    }

    // =====================
    // SEARCH
    // =====================
    public void searchByNama(String nama) {
        try {
            Connection conn = DBConnection.connect();

            String sql = "SELECT * FROM penjualan WHERE nama_pembeli LIKE '%" + nama + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n=== HASIL SEARCH ===");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-3s %-15s %-10s %-5s %-10s%n",
                    "ID", "Nama", "Varian", "Jml", "Asal");
            System.out.println("----------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-3d %-15s %-10s %-5d %-10s%n",
                        rs.getInt("id"),
                        rs.getString("nama_pembeli"),
                        rs.getString("varian"),
                        rs.getInt("jumlah"),
                        rs.getString("asal_pesanan")
                );
            }

        } catch (Exception e) {
            System.out.println("❌ Error search: " + e.getMessage());
        }
    }

    // =====================
    // 🧾 CETAK STRUK (FITUR UTAMA)
    // =====================
    public void cetakStruk(String nama) {
    try {
        Connection conn = DBConnection.connect();

        String sql = "SELECT * FROM penjualan WHERE nama_pembeli = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nama);

        ResultSet rs = ps.executeQuery();

        int grandTotal = 0;

        StringBuilder struk = new StringBuilder();

        struk.append("======================================\n");
        struk.append("         STRUK PEMBELIAN\n");
        struk.append("   COOKIES IN YOUR HEART\n");
        struk.append("======================================\n");

        boolean adaData = false;

        while (rs.next()) {
            adaData = true;

            String namaPembeli = rs.getString("nama_pembeli");
            String varian = rs.getString("varian");
            String rasa = rs.getString("rasa");
            int jumlah = rs.getInt("jumlah");
            int harga = rs.getInt("harga_satuan");

            int subtotal = jumlah * harga;
            grandTotal += subtotal;

            struk.append("Nama     : ").append(namaPembeli).append("\n");
            struk.append("Varian   : ").append(varian).append("\n");
            struk.append("Rasa     : ").append(rasa).append("\n");
            struk.append("Jumlah   : ").append(jumlah).append("\n");
            struk.append("Harga    : ").append(harga).append("\n");
            struk.append("Subtotal : ").append(subtotal).append("\n");
            struk.append("--------------------------------------\n");
        }

        if (!adaData) {
            System.out.println("❌ Data tidak ditemukan!");
            return;
        }

        struk.append("GRAND TOTAL: ").append(grandTotal).append("\n");
        struk.append("======================================\n");

        // =========================
        // TAMPILKAN DI TERMINAL
        // =========================
        System.out.println(struk);

        // =========================
        // EXPORT KE FILE TXT
        // =========================
        String fileName = "struk_" + nama + "_" + System.currentTimeMillis() + ".txt";

        FileWriter fw = new FileWriter(fileName);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(struk.toString());
        pw.close();

        System.out.println("✔ Struk berhasil disimpan ke file: " + fileName);

    } catch (Exception e) {
        System.out.println("❌ Error cetak struk: " + e.getMessage());
    }
    }
}
