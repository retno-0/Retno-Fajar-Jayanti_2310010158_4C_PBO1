package TokoBunga;

import java.util.Scanner;

public class Main {
    // Array
    static DataBunga[] daftarBunga = new DataBunga[100];
    static DataTransaksi[] daftarTransaksi = new DataTransaksi[100];

    // COunter
    static int jumlahBunga = 0;
    static int jumlahTransaksi = 0;

    //Scanner
    static Scanner input = new Scanner(System.in);

    // Polymorphism: objek subclass disimpan sebagai superclass
    public static void main(String[] args) {
        // Menambahkan 3 data awal
        daftarBunga[jumlahBunga++] = new DataBunga("Mawar", 15000, 10);
        daftarBunga[jumlahBunga++] = new DataBunga("Melati", 12000, 8);
        daftarBunga[jumlahBunga++] = new BungaDiskon("Anggrek", 25000, 5, 10);  // Subclass

        int pilihan;

        do {
            //Menu utama
            System.out.println("\n========================================");
            System.out.println("        💐 TOKO BUNGA NINO 💐           ");
            System.out.println("========================================");
            System.out.println("1. Tambah Bunga");
            System.out.println("2. Tampilkan Daftar Bunga");
            System.out.println("3. Beli Bunga");
            System.out.println("4. Lihat Transaksi");
            System.out.println("5. Keluar");

            try { // Error handling
                System.out.print("Pilihan: ");
                pilihan = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Input harus berupa angka!");
                input.nextLine();
                pilihan = 0;
            }

            // Seleksi menu
            switch (pilihan) {
                case 1: tambahBunga(); break;
                case 2: tampilkanBunga(); break;
                case 3: beliBunga(); break;
                case 4: tampilkanTransaksi(); break;
                case 5: System.out.println("🌷 Terima kasih telah berbelanja di Toko Bunga Nino! 🌷"); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    // Method tambahBunga
    static void tambahBunga() {
        System.out.print("Nama bunga: ");
        String nama = input.nextLine();
        System.out.print("Harga: ");
        int harga = input.nextInt();
        System.out.print("Stok: ");
        int stok = input.nextInt();
        input.nextLine();

        System.out.print("Apakah ini bunga promo? (y/n): ");
        String promo = input.nextLine();

        if (promo.equalsIgnoreCase("y")) {
            System.out.print("Diskon %: ");
            double diskon = input.nextDouble();
            input.nextLine();
            
            // Polymorphism: membuat objek subclass
            daftarBunga[jumlahBunga++] = new BungaDiskon(nama, harga, stok, diskon); // ✅ Subclass
        } else {
            // Menambahkan objek superclass
            daftarBunga[jumlahBunga++] = new DataBunga(nama, harga, stok); // ✅ Superclass
        }

        System.out.println("Bunga berhasil ditambahkan!");
    }

    // Method tampilkanBunga
    static void tampilkanBunga() {
        if (jumlahBunga == 0) {
            System.out.println("Belum ada bunga di daftar.");
            return;
        }

        System.out.println("========================================");
        System.out.println("      🌸 DAFTAR BUNGA TOKO NINO 🌸     ");
        System.out.println("========================================");
        System.out.printf("| %-3s | %-12s | %-10s | %-5s |\n", "No", "Nama Bunga", "Harga", "Stok");
        System.out.println("----------------------------------------");

        for (int i = 0; i < jumlahBunga; i++) {
        DataBunga bunga = daftarBunga[i]; // Polymorphism
        String nama = bunga.getNama();
        String hargaTampil = "Rp" + bunga.getHarga();

        if (bunga.isDiskon()) {
            hargaTampil += "*";
            nama += " 🌷";
        }

        System.out.printf("| %-3d | %-14s | %-10s | %-5d |\n", 
            (i + 1), nama, hargaTampil, bunga.getStok());
        }

        System.out.println("========================================");
        System.out.println("* Harga sudah termasuk diskon");
    }

    // Method beliBunga
    static void beliBunga() {
        if (jumlahBunga == 0) {
            System.out.println("Belum ada bunga yang tersedia.");
            return;
        }

        tampilkanBunga();
        System.out.print("Pilih nomor bunga: ");
        int index = input.nextInt() - 1;

        // Validasi indeks
        if (index < 0 || index >= jumlahBunga) {
            System.out.println("❌ Nomor tidak valid.");
            return;
        }

        DataBunga bungaDipilih = daftarBunga[index];
        int jumlah;

        try {
            System.out.print("Jumlah yang dibeli: ");
            jumlah = input.nextInt();
        } catch (Exception e) {
            System.out.println("❌ Masukkan jumlah angka yang valid!");
            input.nextLine();
            return;
        }

        if (jumlah > bungaDipilih.getStok()) {
            System.out.println("❌ Stok tidak mencukupi!");
        } else {
            // Mutator: mengurangi stok
            bungaDipilih.setStok(bungaDipilih.getStok() - jumlah);
            daftarTransaksi[jumlahTransaksi++] = new DataTransaksi(
                bungaDipilih.getNama(), jumlah, bungaDipilih.getHarga() // Harga yang digunakan otomatis sesuai subclass
            );
            System.out.println("Transaksi berhasil!");
        }
    }

    // Method tampilkanTransaksi
    static void tampilkanTransaksi() {
        if (jumlahTransaksi == 0) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("        💐 RIWAYAT TRANSAKSI 💐         ");
        System.out.println("========================================");
        System.out.printf("| %-3s | %-15s | %-6s | %-10s |\n", "No", "Nama", "Qty", "Total");
        System.out.println("----------------------------------------");

        for (int i = 0; i < jumlahTransaksi; i++) {
            DataTransaksi t = daftarTransaksi[i];
            System.out.printf("| %-3d | %-15s | %-6d | Rp%-8d |\n",
                    (i + 1), t.getNamaBunga(), t.getJumlah(), t.getTotal());
        }

        System.out.println("========================================");
    }
}