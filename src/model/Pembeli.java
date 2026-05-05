package model;

public class Pembeli {
    protected String namaPembeli;
    protected int nomorAntrian;

    public Pembeli(String namaPembeli, int nomorAntrian) {
        this.namaPembeli = namaPembeli;
        this.nomorAntrian = nomorAntrian;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public int getNomorAntrian() {
        return nomorAntrian;
    }
}