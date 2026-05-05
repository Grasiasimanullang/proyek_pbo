package cookies.model;

public class OnlineSale extends Sale {
    private static final double SERVICE_FEE = 2000.0;

    public OnlineSale(String name, String queue, String var, String flav, int qty, double price, String pkg, String org) {
        super(name, queue, var, flav, qty, price, pkg, org);
    }

    @Override
    public double calculateTotal() {
        return (quantity * unitPrice) + SERVICE_FEE;
    }
}
