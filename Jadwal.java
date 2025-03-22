import java.util.ArrayList;
import java.util.List;

class Jadwal {
    private int id;
    private String tanggal;
    private String asal;
    private String tujuan;
    private Kereta kereta;

    private static List<Jadwal> daftarJadwal = new ArrayList<>(); // Daftar jadwal statis

    public Jadwal(int id, String tanggal, String asal, String tujuan, Kereta kereta) {
        this.id = id;
        this.tanggal = tanggal;
        this.asal = asal;
        this.tujuan = tujuan;
        this.kereta = kereta;
        kereta.tambahJadwal(this);
        daftarJadwal.add(this); // Tambahkan ke daftar statis
    }

    public static void tampilkanKeretaBerdasarkanJadwal(String tanggal, String asal, String tujuan) {
        System.out.println("Daftar Kereta untuk Tanggal " + tanggal + " dari " + asal + " ke " + tujuan + ":");

        boolean adaJadwal = false;
        for (Jadwal jadwal : daftarJadwal) {
            if (jadwal.tanggal.equals(tanggal) &&
                jadwal.asal.equalsIgnoreCase(asal) &&
                jadwal.tujuan.equalsIgnoreCase(tujuan)) {
                jadwal.kereta.tampilkanInfo();
                adaJadwal = true;
            }
        }
        if (!adaJadwal) {
            System.out.println("Tidak ada kereta yang tersedia untuk jadwal tersebut.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Jadwal: " + tanggal + " dari " + asal + " ke " + tujuan);
        kereta.tampilkanInfo();
    }
}
