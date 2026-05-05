import java.util.List;

public class Main {
    public static void main(String[] args) {

        MahasiswaMapper mapper = new MahasiswaMapper();

        // INSERT DATA
        mapper.insert(new Mahasiswa(0, "Andi", "Informatika"));

        // AMBIL DATA
        List<Mahasiswa> data = mapper.getAll();

        System.out.println("ID | Nama   | Jurusan");
        System.out.println("---------------------------");

        for (Mahasiswa m : data) {
            System.out.printf("%-2d | %-6s | %-15s\n",
                    m.getId(),
                    m.getNama(),
                    m.getJurusan());
        }
    }
}