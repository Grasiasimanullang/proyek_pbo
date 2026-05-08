// FILE: src/model/Cookies.java

package model;

public class Cookies {

    private int id;
    private String namaPelanggan;
    private int nomorAntrian;
    private String namaMenu;
    private int harga;
    private int jumlah;
    private int total;

    public Cookies(String namaPelanggan,
                   int nomorAntrian,
                   String namaMenu,
                   int harga,
                   int jumlah,
                   int total) {

        this.namaPelanggan = namaPelanggan;
        this.nomorAntrian = nomorAntrian;
        this.namaMenu = namaMenu;
        this.harga = harga;
        this.jumlah = jumlah;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public int getNomorAntrian() {
        return nomorAntrian;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getTotal() {
        return total;
    }
}