abstract class Pembayaran {
    protected double jumlah;
    protected String status;
    
    public Pembayaran(double jumlah) {
        this.jumlah = jumlah;
        this.status = "Belum Dibayar";
    }
    
    public abstract void prosesPembayaran();
}