public class PembayaranCash extends Pembayaran{
    private double jumlahDiterima;
    private double kembalian;

    public PembayaranCash(double jumlah, double jumlahDiterima) {
        super(jumlah);
        this.jumlahDiterima = jumlahDiterima;
        this.kembalian = jumlahDiterima - jumlah;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Pembayaran sebesar Rp" + jumlah + " dilakukan secara tunai.");
        System.out.println("Jumlah diterima: Rp" + jumlahDiterima);
        System.out.println("Kembalian: Rp" + kembalian);
        status = "Berhasil";
    }
}
