package TokoBunga;

public class BungaDiskon extends DataBunga {
    private double diskon; // persen(%)

    // Constructor
    public BungaDiskon(String nama, int harga, int stok, double diskon) {
        super(nama, harga, stok);
        this.diskon = diskon;
    }

    // Accessor
    public double getDiskon() {
        return diskon;
    }

    // Mutator
    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    @Override // Override harga agar diskon otomatis dihitung
    public int getHarga() {
        return (int)(super.getHarga() * (1 - diskon / 100));
    }
    
    @Override
    public boolean isDiskon() {
    return true; // Ini objek diskon
}

    @Override
    public String getInfo() {
        return super.getInfo() + " (Diskon " + diskon + "%)";
    }
}