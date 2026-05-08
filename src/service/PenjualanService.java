// FILE: src/service/PenjualanService.java

package service;

import db.DBConnection;
import mapper.PenjualanMapper;
import model.Cookies;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PenjualanService {

    PenjualanMapper mapper =
        new PenjualanMapper();

    // =========================
    // TAMBAH DATA
    // =========================
    public void tambah(Cookies c) {

        mapper.insert(c);
    }

    // =========================
    // DELETE PER ID
    // =========================
    public void delete(int id) {

        try {

            Connection conn =
                DBConnection.connect();

            String sql =
                "DELETE FROM penjualan WHERE id = ?";

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setInt(1, id);

            int result =
                ps.executeUpdate();

            if (result > 0) {

                System.out.println("✔ Data berhasil dihapus");

            } else {

                System.out.println("❌ ID tidak ditemukan");
            }

        } catch (Exception e) {

            System.out.println("❌ Error delete: " + e.getMessage());
        }
    }

    // =========================
    // DELETE ALL + RESET ID
    // =========================
    public void deleteAll() {

        try {

            Connection conn =
                DBConnection.connect();

            String sql1 =
                "DELETE FROM penjualan";

            PreparedStatement ps1 =
                conn.prepareStatement(sql1);

            ps1.executeUpdate();

            String sql2 =
                "DELETE FROM sqlite_sequence WHERE name='penjualan'";

            PreparedStatement ps2 =
                conn.prepareStatement(sql2);

            ps2.executeUpdate();

            System.out.println("✔ Semua data berhasil dihapus");
            System.out.println("✔ ID berhasil direset ke 1");

        } catch (Exception e) {

            System.out.println("❌ Error delete all: " + e.getMessage());
        }
    }

    // =========================
    // CETAK STRUK PREMIUM
    // =========================
    public void cetakStruk(String namaPelanggan) {

        try {

            Connection conn =
                DBConnection.connect();

            String sql =
                "SELECT * FROM penjualan WHERE nama_pelanggan = ?";

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setString(1, namaPelanggan);

            ResultSet rs =
                ps.executeQuery();

            StringBuilder struk =
                new StringBuilder();

            struk.append("\n");
            struk.append("============================================================\n");
            struk.append("                 COOKIES IN YOUR HEART\n");
            struk.append("============================================================\n");
            struk.append("Nama Pelanggan : ")
                 .append(namaPelanggan)
                 .append("\n");
            struk.append("============================================================\n");

            struk.append(String.format(
                "%-3s %-28s %-8s %-8s %-10s\n",
                "No",
                "Menu",
                "Qty",
                "Harga",
                "Total"
            ));

            struk.append("------------------------------------------------------------\n");

            int no = 1;
            int grandTotal = 0;

            while (rs.next()) {

                String menu =
                    rs.getString("nama_menu");

                int harga =
                    rs.getInt("harga");

                int jumlah =
                    rs.getInt("jumlah");

                int total =
                    rs.getInt("total");

                grandTotal += total;

                struk.append(String.format(
                    "%-3d %-28s %-8d %-8d %-10d\n",
                    no++,
                    menu,
                    jumlah,
                    harga,
                    total
                ));
            }

            struk.append("------------------------------------------------------------\n");

            // =========================
            // DISKON
            // =========================
            int diskon = 0;

            if (grandTotal >= 100000) {

                diskon =
                    (int) (grandTotal * 0.05);
            }

            int totalBayar =
                grandTotal - diskon;

            struk.append(String.format(
                "%-40s : Rp%d\n",
                "Subtotal",
                grandTotal
            ));

            struk.append(String.format(
                "%-40s : Rp%d\n",
                "Diskon 5%",
                diskon
            ));

            struk.append(String.format(
                "%-40s : Rp%d\n",
                "Grand Total",
                totalBayar
            ));

            struk.append("============================================================\n");

            if (diskon > 0) {

                struk.append("   🎉 SELAMAT! ANDA MENDAPATKAN DISKON 5% 🎉\n");
            }

            struk.append("        TERIMA KASIH TELAH MEMBELI COOKIES\n");
            struk.append("                 COME AGAIN ❤️\n");
            struk.append("============================================================\n");

            // tampilkan di terminal
            System.out.println(struk);

            // simpan file
            String fileName =
                "struk_" + namaPelanggan + ".txt";

            FileWriter writer =
                new FileWriter(fileName);

            writer.write(struk.toString());

            writer.close();

            System.out.println("✔ Struk berhasil disimpan");
            System.out.println("📄 File : " + fileName);

        } catch (Exception e) {

            System.out.println("❌ Error cetak struk: " + e.getMessage());
        }
    }
}