package TokoBunga;

public class DataTransaksi {
    private String namaBunga;
    private int jumlah;
    private int total;

    public DataTransaksi(String namaBunga, int jumlah, int hargaSatuan) {
        this.namaBunga = namaBunga;
        this.jumlah = jumlah;
        this.total = jumlah * hargaSatuan;
    }

    public String getNamaBunga() {
        return namaBunga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getTotal() {
        return total;
    }
}