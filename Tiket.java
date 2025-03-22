import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Tiket extends Pelanggan{
    private String kodeTiket;
    private String idPenumpang;
    private String namaPenumpang;
    private String asal;
    private String tujuan;
    private String jenisKereta;
    private String tipePenumpang;
    private String noTempatDuduk;
    private LocalDateTime tanggalKeberangkatan;
    private LocalDateTime tanggalKedatangan;
    private double harga;
    private boolean status;

    public Tiket(String kodeTiket, String idPenumpang, String namaPenumpang, String asal, String tujuan, String jenisKereta, String tipePenumpang, String noTempatDuduk, LocalDateTime tanggalKeberangkatan, LocalDateTime tanggalKedatangan, double harga) {
        this.kodeTiket = kodeTiket;
        this.idPenumpang = idPenumpang;
        this.namaPenumpang = namaPenumpang;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jenisKereta = jenisKereta;
        this.tipePenumpang = tipePenumpang;
        this.noTempatDuduk = noTempatDuduk;
        this.tanggalKeberangkatan = tanggalKeberangkatan;
        this.tanggalKedatangan = tanggalKedatangan;
        this.harga = harga;
        this.status = false; // Default: tiket belum digunakan
    }

    public String getKodeTiket() {
        return kodeTiket;
    }

    public void setKodeTiket(String kodeTiket) {
        this.kodeTiket = kodeTiket;
    }

    public String getIdPenumpang() {
        return idPenumpang;
    }

    public void setIdPenumpang(String idPenumpang) {
        this.idPenumpang = idPenumpang;
    }

    public String getNamaPenumpang() {
        return namaPenumpang;
    }

    public void setNamaPenumpang(String namaPenumpang) {
        this.namaPenumpang = namaPenumpang;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getJenisKereta() {
        return jenisKereta;
    }

    public void setJenisKereta(String jenisKereta) {
        this.jenisKereta = jenisKereta;
    }

    public String getTipePenumpang() {
        return tipePenumpang;
    }

    public void setTipePenumpang(String tipePenumpang) {
        this.tipePenumpang = tipePenumpang;
    }

    public String getNoTempatDuduk() {
        return noTempatDuduk;
    }

    public void setNoTempatDuduk(String noTempatDuduk) {
        this.noTempatDuduk = noTempatDuduk;
    }

    public LocalDateTime getTanggalKeberangkatan() {
        return tanggalKeberangkatan;
    }

    public void setTanggalKeberangkatan(LocalDateTime tanggalKeberangkatan) {
        this.tanggalKeberangkatan = tanggalKeberangkatan;
    }

    public LocalDateTime getTanggalKedatangan() {
        return tanggalKedatangan;
    }

    public void setTanggalKedatangan(LocalDateTime tanggalKedatangan) {
        this.tanggalKedatangan = tanggalKedatangan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public boolean isUsed() {
        return status;
    }

    public void setUsed(boolean status) {
        this.status = status;
    }

    public void gunakanTiket() throws Exception {
        if (status) {
            throw new Exception("Tiket sudah digunakan!");
        }
        status = true;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm", Locale.getDefault());
        return "Tiket[kodeTiket=" + kodeTiket + ", idPenumpang=" + idPenumpang + ", namaPenumpang=" + namaPenumpang +
                ", asal=" + asal + ", tujuan=" + tujuan + ", jenisKereta=" + jenisKereta + ", tipePenumpang=" + tipePenumpang +
                ", noTempatDuduk=" + noTempatDuduk + ", tanggalKeberangkatan=" + tanggalKeberangkatan.format(formatter) +
                ", tanggalKedatangan=" + tanggalKedatangan.format(formatter) + ", harga=" + harga + ", status=" + (status ? "Digunakan" : "Belum Digunakan") + "]";
    }
}
