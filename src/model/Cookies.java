package model;

public class Cookies extends Pembeli {

    private String varian;
    private String rasa;
    private int jumlah;
    private int hargaSatuan;
    private String packaging;
    private String asalPesanan;

    public Cookies(String nama, int antrian,
                   String varian, String rasa,
                   int jumlah, int hargaSatuan,
                   String packaging, String asalPesanan) {

        super(nama, antrian);
        this.varian = varian;
        this.rasa = rasa;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.packaging = packaging;
        this.asalPesanan = asalPesanan;
    }

    public String getVarian() { return varian; }
    public String getRasa() { return rasa; }
    public int getJumlah() { return jumlah; }
    public int getHargaSatuan() { return hargaSatuan; }
    public String getPackaging() { return packaging; }
    public String getAsalPesanan() { return asalPesanan; }

    public int getTotalHarga() {
        return jumlah * hargaSatuan;
    }
}