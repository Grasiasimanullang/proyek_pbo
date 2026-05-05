package cookies.model;

public abstract class Sale {
    protected String buyerName;
    protected String queueNumber;
    protected String variant;
    protected String flavor;
    protected int quantity;
    protected double unitPrice;
    protected String packaging;
    protected String origin;

    public Sale(String buyerName, String queueNumber, String variant, String flavor, 
                int quantity, double unitPrice, String packaging, String origin) {
        this.buyerName = buyerName;
        this.queueNumber = queueNumber;
        this.variant = variant;
        this.flavor = flavor;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.packaging = packaging;
        this.origin = origin;
    }

    // Method untuk menghitung total (akan di-override di Task 02)
    public double calculateTotal() {
        return this.quantity * this.unitPrice;
    }

    // Getter untuk keperluan output
    public String getBuyerName() { return buyerName; }
    public String getQueueNumber() { return queueNumber; }
    public String getVariant() { return variant; }
    public int getQuantity() { return quantity; }
}