import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservasi {
    // Enum untuk status reservasi
    public enum StatusReservasi {
        DIBUAT,
        MENUNGGU_PEMBAYARAN,
        DIBAYAR,
        DIBATALKAN,
        SELESAI
    }
    
    private String idReservasi;
    private String pelanggan; // Idealnya menggunakan class Pelanggan
    private String tiket; // Idealnya menggunakan class Tiket
    private Kursi kursi;
    private StatusReservasi status;
    private LocalDateTime waktuPemesanan;
    private LocalDateTime batasWaktuPembayaran;
    private double jumlahPembayaran;
    private String metodePembayaran;
    
    public Reservasi(String idReservasi, String pelanggan, String tiket, Kursi kursi, double jumlahPembayaran) {
        // Validasi kursi tersedia
        if (!kursi.isTersedia()) {
            throw new IllegalArgumentException("Kursi " + kursi.getNomorKursi() + " tidak tersedia.");
        }
        
        this.idReservasi = idReservasi;
        this.pelanggan = pelanggan;
        this.tiket = tiket;
        this.kursi = kursi;
        this.jumlahPembayaran = jumlahPembayaran;
        this.status = StatusReservasi.DIBUAT;
        this.waktuPemesanan = LocalDateTime.now();
        // Batas waktu pembayaran 2 jam setelah pemesanan
        this.batasWaktuPembayaran = waktuPemesanan.plusHours(2);
    }
    
    public boolean cekBatasWaktuPembayaran() {
        return LocalDateTime.now().isBefore(batasWaktuPembayaran);
    }
    
    public void lakukanPembayaran(String metodePembayaran) {
        if (status == StatusReservasi.DIBATALKAN) {
            System.out.println("Reservasi telah dibatalkan, tidak dapat melakukan pembayaran.");
            return;
        }
        
        if (status == StatusReservasi.DIBAYAR) {
            System.out.println("Reservasi ini sudah dibayar.");
            return;
        }
        
        if (!cekBatasWaktuPembayaran()) {
            batalkanReservasi();
            System.out.println("Batas waktu pembayaran telah terlewat. Reservasi dibatalkan.");
            return;
        }
        
        this.metodePembayaran = metodePembayaran;
        status = StatusReservasi.DIBAYAR;
        kursi.pesanKursi();
        System.out.println("Pembayaran untuk reservasi " + idReservasi + " berhasil dengan metode " + metodePembayaran);
    }
    
    public void batalkanReservasi() {
        if (status == StatusReservasi.DIBATALKAN) {
            System.out.println("Reservasi sudah dibatalkan sebelumnya.");
            return;
        }
        
        if (status == StatusReservasi.DIBAYAR) {
            kursi.batalkanKursi();
        }
        
        status = StatusReservasi.DIBATALKAN;
        System.out.println("Reservasi " + idReservasi + " dibatalkan.");
    }
    
    public void tandaiSelesai() {
        if (status == StatusReservasi.DIBAYAR) {
            status = StatusReservasi.SELESAI;
            System.out.println("Reservasi " + idReservasi + " telah selesai.");
        } else {
            System.out.println("Reservasi harus sudah dibayar untuk ditandai selesai.");
        }
    }
    
    public void tampilkanDetail() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        
        System.out.println("========== DETAIL RESERVASI ==========");
        System.out.println("ID Reservasi: " + idReservasi);
        System.out.println("Pelanggan: " + pelanggan);
        System.out.println("Tiket: " + tiket);
        System.out.println("Kursi: " + kursi.getNomorKursi());
        System.out.println("Status: " + status);
        System.out.println("Waktu Pemesanan: " + waktuPemesanan.format(formatter));
        System.out.println("Batas Waktu Pembayaran: " + batasWaktuPembayaran.format(formatter));
        System.out.println("Jumlah Pembayaran: Rp " + String.format("%,.2f", jumlahPembayaran));
        
        if (status == StatusReservasi.DIBAYAR || status == StatusReservasi.SELESAI) {
            System.out.println("Metode Pembayaran: " + metodePembayaran);
        }
        
        System.out.println("======================================");
    }
    
    public String generateBuktiReservasi() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        
        StringBuilder bukti = new StringBuilder();
        bukti.append("BUKTI RESERVASI - TIKET KERETA API\n");
        bukti.append("================================\n");
        bukti.append("ID: ").append(idReservasi).append("\n");
        bukti.append("Pelanggan: ").append(pelanggan).append("\n");
        bukti.append("Tiket: ").append(tiket).append("\n");
        bukti.append("Kursi: ").append(kursi.getNomorKursi()).append("\n");
        bukti.append("Tanggal Pemesanan: ").append(waktuPemesanan.format(formatter)).append("\n");
        
        if (status == StatusReservasi.DIBAYAR || status == StatusReservasi.SELESAI) {
            bukti.append("Status: Sudah Dibayar\n");
            bukti.append("Metode Pembayaran: ").append(metodePembayaran).append("\n");
        } else {
            bukti.append("Status: Belum Dibayar\n");
            bukti.append("Batas Waktu Pembayaran: ").append(batasWaktuPembayaran.format(formatter)).append("\n");
        }
        
        bukti.append("================================\n");
        return bukti.toString();
    }
    
    // Getter dan setter lainnya sesuai kebutuhan
}
