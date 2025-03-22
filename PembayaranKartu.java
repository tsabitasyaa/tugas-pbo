public class PembayaranKartu extends Pembayaran{
    private String nomorKartu;
    private String namaPemilik;

    public PembayaranKartu(double jumlah, String nomorKartu, String namaPemilik) {
        super(jumlah);
        this.nomorKartu = nomorKartu;
        this.namaPemilik = namaPemilik;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Pembayaran sebesar Rp" + jumlah + " menggunakan kartu atas nama " + namaPemilik);
        System.out.println("Nomor Kartu: " + nomorKartu);
        status = "Berhasil";
    }

}
