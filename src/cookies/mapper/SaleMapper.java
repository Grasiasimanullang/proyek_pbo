package cookies.mapper;
import cookies.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SaleMapper {
    public void save(Sale sale) {
        String sql = "INSERT INTO sales(buyer_name, queue_number, variant, flavor, qty, price, packaging, origin, type) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DatabaseConfig.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sale.getBuyerName());
            pstmt.setString(2, sale.getQueueNumber());
            pstmt.setString(3, sale.getVariant());
            pstmt.setString(4, "N/A"); // Misal flavor
            pstmt.setInt(5, sale.getQuantity());
            pstmt.setDouble(6, 0.0); // Misal unitPrice jika di Sale ada
            pstmt.setString(7, "Box"); // Placeholder
            pstmt.setString(8, sale.calculateTotal() + ""); // Placeholder origin
            pstmt.setString(9, (sale instanceof OnlineSale) ? "ONLINE" : "INSTORE");
            
            // Catatan: Pastikan field di Sale.java punya getter yang lengkap
            // Di sini kita pakai parameter sesuai struktur Task 01 & 02
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Gagal menyimpan data: " + e.getMessage());
        }
    }
}
