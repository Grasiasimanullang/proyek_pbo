public class Mahasiswa extends Person {
    private String jurusan;

    public Mahasiswa(int id, String nama, String jurusan) {
        super(id, nama);
        this.jurusan = jurusan;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getJurusan() { return jurusan; }
}