package cookies.driver;

import java.util.*;
import cookies.model.*;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Sale> sales = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("---")) break;
            String[] d = line.split("#");
            if (d[0].equals("add-sale") && d.length >= 9) {
                String origin = d[8];
                if (origin.equalsIgnoreCase("Datang ke Toko")) {
                    sales.add(new InStoreSale(d[1], d[2], d[3], d[4], Integer.parseInt(d[5]), Double.parseDouble(d[6]), d[7], d[8]));
                } else {
                    sales.add(new OnlineSale(d[1], d[2], d[3], d[4], Integer.parseInt(d[5]), Double.parseDouble(d[6]), d[7], d[8]));
                }
            }
        }
        for (Sale s : sales) {
            System.out.println(s.getBuyerName() + "|" + s.getQueueNumber() + "|" + s.getVariant() + "|" + s.getQuantity() + "|" + s.calculateTotal());
        }
        sc.close();
    }
}
