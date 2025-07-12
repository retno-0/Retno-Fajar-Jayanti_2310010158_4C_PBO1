package TokoBunga;

// Atribute
public class DataBunga {
    private String nama;
    private int harga;
    private int stok;

    // Constructor
    public DataBunga(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Accessor
    public String getNama() { return nama; }
    public int getHarga() { return harga; } // Polymorphism
    public int getStok() { return stok; }

    // Mutator
    public void setNama(String nama) { this.nama = nama; }
    public void setHarga(int harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }

    // Tambahan method untuk mendeteksi apakah objek diskon atau bukan
    public boolean isDiskon() {
    return false; // Default: bukan diskon
    }
    
    // Polymorphism
    public String getInfo() {
        return "Nama: " + nama + ", Harga: Rp" + harga + ", Stok: " + stok;
    }
}