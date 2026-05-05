package cookies.driver;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import cookies.model.Sale;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Sale> salesList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] data = input.split("#");
            
            // Format: add-sale#nama#antrian#varian#rasa#qty#harga#pkg#asal
            if (data[0].equals("add-sale")) {
                String name = data[1];
                String queue = data[2];
                String variant = data[3];
                String flavor = data[4];
                int qty = Integer.parseInt(data[5]);
                double price = Double.parseDouble(data[6]);
                String pkg = data[7];
                String origin = data[8];

                // Untuk Task 01, kita gunakan anonim subclass dulu atau class biasa
                Sale newSale = new Sale(name, queue, variant, flavor, qty, price, pkg, origin) {};
                salesList.add(newSale);
            }
        }

        // Output sederhana sesuai Task 01
        for (Sale s : salesList) {
            System.out.println(s.getBuyerName() + "|" + 
                               s.getQueueNumber() + "|" + 
                               s.getVariant() + "|" + 
                               s.getQuantity() + "|" + 
                               s.calculateTotal());
        }
        
        sc.close();
    }
}