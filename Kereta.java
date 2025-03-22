import java.util.ArrayList;
import java.util.List;

class Kereta {
    private int id;
    private String nama;
    private String kelas;
    private int kapasitas;
    private double harga;
    private List<Jadwal> daftarJadwal;
    private List<Kursi> daftarKursi;
    
    public Kereta(int id, String nama, String kelas, int kapasitas, double harga) {
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
        this.kapasitas = kapasitas;
        this.harga = harga;
        this.daftarJadwal = new ArrayList<>();
        this.daftarKursi = new ArrayList<>();
        for (int i = 1; i <= kapasitas; i++) {
            daftarKursi.add(new Kursi(i));
        }
    }
    public void tambahJadwal(Jadwal jadwal) {
        daftarJadwal.add(jadwal);
    }

    public List<Jadwal> getDaftarJadwal() {
        return daftarJadwal;
    }
    
    public void tampilkanInfo() {
        System.out.println("Kereta: " + nama + ", Kelas: " + kelas + ", Kapasitas: " + kapasitas + ", Harga: Rp" + harga);
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getKelas() {
        return kelas;
    }
    
    public double getHargaDasar() {
        return hargaDasar;
    }
}