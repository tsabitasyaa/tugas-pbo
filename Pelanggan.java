import java.util.ArrayList;
import java.util.List;

class Pelanggan {
    private int id;
    private String nama;
    private String email;
    private List<Jadwal> tiketDipesan;

    public Pelanggan(int id, String nama, String email) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.tiketDipesan = new ArrayList<>();
    }

    public void pesanTiket(String tanggal, String asal, String tujuan) {
        Jadwal jadwal = Jadwal.cariJadwal(tanggal, asal, tujuan);
        if (jadwal != null) {
            tiketDipesan.add(jadwal);
            System.out.println(nama + " berhasil memesan tiket:");
            jadwal.tampilkanInfo();
        } else {
            System.out.println("Maaf, tidak ada jadwal yang tersedia.");
        }
    }

    public void lihatTiket() {
        System.out.println("Tiket yang dipesan oleh " + nama + ":");
        if (tiketDipesan.isEmpty()) {
            System.out.println("Belum ada tiket yang dipesan.");
        } else {
            for (Jadwal jadwal : tiketDipesan) {
                jadwal.tampilkanInfo();
            }
        }
    }
}
