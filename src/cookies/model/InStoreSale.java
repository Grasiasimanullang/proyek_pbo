package cookies.model;

public class InStoreSale extends Sale {
    public InStoreSale(String name, String queue, String var, String flav, int qty, double price, String pkg, String org) {
        super(name, queue, var, flav, qty, price, pkg, org);
    }

    @Override
    public double calculateTotal() {
        return quantity * unitPrice;
    }
}
