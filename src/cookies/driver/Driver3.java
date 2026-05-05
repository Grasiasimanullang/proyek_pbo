package cookies.driver;
import java.util.*;
import cookies.model.*;
import cookies.mapper.*;

public class Driver3 {
    public static void main(String[] args) {
        DatabaseConfig.initializeDatabase();
        SaleMapper mapper = new SaleMapper();
        Scanner sc = new Scanner(System.in);

        System.out.println("Driver3: Input Data ke SQLite (--- untuk selesai)");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("---")) break;
            String[] d = line.split("#");
            if (d[0].equals("add-sale") && d.length >= 9) {
                Sale sale;
                if (d[8].equalsIgnoreCase("Datang ke Toko")) {
                    sale = new InStoreSale(d[1], d[2], d[3], d[4], Integer.parseInt(d[5]), Double.parseDouble(d[6]), d[7], d[8]);
                } else {
                    sale = new OnlineSale(d[1], d[2], d[3], d[4], Integer.parseInt(d[5]), Double.parseDouble(d[6]), d[7], d[8]);
                }
                mapper.save(sale);
                System.out.println("Berhasil disimpan ke database!");
            }
        }
        sc.close();
    }
}
