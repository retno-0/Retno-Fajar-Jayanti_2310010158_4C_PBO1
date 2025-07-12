# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data toko bunga menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini memungkinkan pengguna untuk: menambah data bunga (reguler atau promo dengan diskon), menampilkan daftar bunga, melakukan transaksi pembelian bunga dan melihat riwayat transaksi.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Polymorphism, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `DataBunga`, `BungaDiskon`, `DataTransaksi` dan `Main`.

```bash
public class DataBunga {
    ...
}

public class BungaDiskon extends DataBunga {
    ...
}

public class DataTransaksi {
    ...
}

public class Main {
    ...
}
```

2. **Object** adalah instance dari class.

```bash
daftarBunga[jumlahBunga++] = new BungaDiskon("Anggrek", 25000, 5, 10);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nama`, `harga` dan `stok` adalah contoh atribut.

```bash
Private String nama;
Private int harga;
Private int stok;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `DataBunga`, `BungaDiskon` dan `DataTransaksi`.

```bash
public DataBunga(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
}

public BungaDiskon(String nama, int harga, int stok, double diskon) {
        super(nama, harga, stok);
        this.diskon = diskon;
}

public DataTransaksi(String namaBunga, int jumlah, int hargaSatuan) {
        this.namaBunga = namaBunga;
        this.jumlah = jumlah;
        this.total = jumlah * hargaSatuan;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNama`,`setHarga` dan `setStok` adalah contoh method mutator.

```bash
public void setNama(String nama) {
this.nama = nama;
}

public void setHarga(int harga) {
this.harga = harga;
}

public void setStok(int stok) {
this.stok = stok;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNama`, `getHarga` dan `getStok` adalah contoh method accessor.

```bash
public String getNama() {
return nama;
}

public int getHarga() {
return harga;
}

public int getStok() {
return stok;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `stok` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private int stok;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `BungaDiskon` mewarisi `DataBunga` dengan sintaks `extends`.

```bash
public class BungaDiskon extends DataBunga {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `getHarga` dioverride di `BungaDiskon` untuk menghitung harga diskon.

```bash
@Override
public int getHarga() {
     return (int)(super.getHarga() * (1 - diskon / 100));
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `tambahBunga` dan seleksi `switch-case` dalam Menu.

```bash
if (promo.equalsIgnoreCase("y")) {
    System.out.print("Diskon %: ");
    double diskon = input.nextDouble();
    input.nextLine();
        daftarBunga[jumlahBunga++] = new BungaDiskon(nama, harga, stok, diskon);
} else {
        daftarBunga[jumlahBunga++] = new DataBunga(nama, harga, stok);
}

switch (pilihan) {
      case 1: tambahBunga(); break;
      case 2: tampilkanBunga(); break;
      case 3: beliBunga(); break;
      case 4: tampilkanTransaksi(); break;
      case 5: System.out.println("🌷 Terima kasih telah berbelanja di Toko Bunga Nino! 🌷"); break;
      default: System.out.println("Pilihan tidak valid.");
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk menampilkan daftar bunga dan transaksi.

```bash
for (int i = 0; i < jumlahBunga; i++) {
    ...
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
static Scanner input = new Scanner(System.in);
System.out.print("Nama bunga: ");
String nama = input.nextLine();
System.out.print("Harga: ");
int harga = input.nextInt();
System.out.print("Stok: ");
int stok = input.nextInt();
input.nextLine();

System.out.print("Apakah ini bunga promo? (y/n): ");
String promo = input.nextLine();
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `DataBunga[] daftarBunga = new DataBunga[100];` adalah contoh penggunaan array.

```bash
static DataBunga[] daftarBunga = new DataBunga[100];
static DataTransaksi[] daftarTransaksi = new DataTransaksi[100];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error.

```bash
try {
System.out.print("Pilihan: ");
      pilihan = input.nextInt();
      input.nextLine();
} catch (Exception e) {
      System.out.println("❌ Input harus berupa angka!");
      input.nextLine();
pilihan = 0;
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Retno Fajar Jayanti
NPM: 2310010158
