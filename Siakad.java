package siakad;

import java.util.Scanner;

public class Siakad {
    // array dan scanner
    static Scanner input = new Scanner(System.in);
    static Mahasiswa[] daftarMhs = new Mahasiswa[100];
    static int jumlahMhs = 0;
    
    
    public static void main(String[] args) {
        // Inisialisasi data
        Dosen dosenAndi = new DosenTetap("Yuliana", "20001");
        Mahasiswa andi = new MahasiswaReguler("2310001", "Andi Pratama", "Informatika", 3.75, 50, 19); 
        andi.setDosenWali(dosenAndi);
        daftarMhs[jumlahMhs++] = andi;

        int pilihan;

        // Dosen dosen1 = new DosenTetap("Budi", "19800101");

        // System.out.println("===== TESTING ABSENSI DOSEN =====");
        // dosen1.tampilDataDosen();
        // dosen1.absen();
        DosenTetap dosenYuliana = new DosenTetap("Yuliana", "20001");

        System.out.println("===== TESTING INTERFACE =====");
        dosenYuliana.tambahData();
        dosenYuliana.ubahData();

        // menu utama menggunakan do-while(Perulangan)
        do {
            System.out.println("\n===== MENU SIAKAD =====");
            System.out.println("1. Daftar Mahasiswa");
            System.out.println("2. Cari Data Mahasiswa Berdasarkan NIM");
            System.out.println("3. Hitung Rata-Rata IPK");
            System.out.println("4. Ganti Dosen Wali");
            System.out.println("5. Tambah Mahasiswa Baru");
            System.out.println("6. Kelola KRS Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            
            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                input.nextLine();
            } else {
                pilihan = -1;
                input.nextLine();
            }

            if (pilihan == 1) {
                tampilkanMahasiswa();
            } else if (pilihan == 2) {
                cariMahasiswa();
            } else if (pilihan == 3) {
                hitungRataIpk();
            } else if (pilihan == 4) {
                gantiDosenWali();
            } else if (pilihan == 5) {
                tambahMahasiswa();
            } else if (pilihan == 6) {
                menuKRS();
            } else if (pilihan == 0) {
                System.out.println("Keluar dari program...");
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
    
    // Method untuk mencari objek Mahasiswa berdasarkan NIM
    static Mahasiswa getMahasiswaByNim(String nim) {
        for (int i = 0; i < jumlahMhs; i++) {
            if (daftarMhs[i].getNim().equals(nim)) {
                return daftarMhs[i];
            }
        }
        return null;
    }
    
    // --- MENU KRS MAHASISWA (1.c) ---
    static void menuKRS() {
        System.out.print("Masukkan NIM Mahasiswa yang akan dikelola KRS-nya: ");
        String nim = input.nextLine();
        Mahasiswa mhs = getMahasiswaByNim(nim);

        if (mhs == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
            return;
        }

        int pilihanKRS;
        do {
            System.out.println("\n===== KELOLA KRS MAHASISWA " + mhs.getNama() + " =====");
            System.out.println("1. Tambah Mata Kuliah ke KRS");
            System.out.println("2. Hapus Mata Kuliah dari KRS");
            System.out.println("3. Lihat KRS Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            
            if (input.hasNextInt()) {
                pilihanKRS = input.nextInt();
                input.nextLine();
            } else {
                pilihanKRS = -1;
                input.nextLine();
            }

            if (pilihanKRS == 1) {
                tambahMKtoKRS(mhs);
            } else if (pilihanKRS == 2) {
                hapusMKfromKRS(mhs);
            } else if (pilihanKRS == 3) {
                mhs.tampilKRS();
            } else if (pilihanKRS == 0) {
                System.out.println("Kembali ke Menu Utama...");
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        } while (pilihanKRS != 0);
    }

    // Method tambah Mata Kuliah ke KRS
    static void tambahMKtoKRS(Mahasiswa mhs) {
        System.out.println("\n--- TAMBAH MATA KULIAH ---");
        System.out.print("Masukkan Kode Mata Kuliah: ");
        String kode = input.nextLine().toUpperCase();
        
        // Cek apakah kode kosong
        if (kode.trim().isEmpty()) {
            System.out.println("Validasi Gagal: Kode MK tidak boleh kosong!");
            return;
        }
        
        System.out.print("Masukkan Nama Mata Kuliah: ");
        String namaMk = input.nextLine();
        
        System.out.print("Masukkan SKS (1-6): ");
        if (!input.hasNextInt()) {
            System.out.println("Validasi Gagal: SKS harus berupa angka!");
            input.nextLine();
            return;
        }
        int sks = input.nextInt();
        input.nextLine();
        
        MataKuliah mkBaru = new MataKuliah(kode, namaMk, sks);

        if (mkBaru.getKode_matkul() == null || mkBaru.getSks() == 0) {
            return;
        }

        if (mhs.tambahMataKuliah(mkBaru)) {
            System.out.println("Mata kuliah " + kode + " berhasil ditambahkan ke KRS.");
        } 
    }

    // Method hapus Mata Kuliah dari KRS
    static void hapusMKfromKRS(Mahasiswa mhs) {
        System.out.println("\n--- HAPUS MATA KULIAH ---");
        System.out.print("Masukkan Kode Mata Kuliah yang akan dihapus: ");
        String kode = input.nextLine().toUpperCase();
        
        if (mhs.hapusMataKuliah(kode)) {
            System.out.println("Mata kuliah " + kode + " berhasil dihapus dari KRS.");
        } else {
            System.out.println("Mata kuliah dengan kode " + kode + " tidak ditemukan di KRS.");
        }
    }

    // method untuk menampilkan daftar mahasiswa
    static void tampilkanMahasiswa() {
        if (jumlahMhs == 0) {
            System.out.println("Belum ada data mahasiswa!");
        } else {
            System.out.println("\n===== DAFTAR MAHASISWA =====");
            for (int i = 0; i < jumlahMhs; i++) {
                System.out.println((i + 1) + ". " + daftarMhs[i].getNama() + " (" + daftarMhs[i].getNim() + ")");
                daftarMhs[i].tampilData();
                System.out.println("-------------------------------");
            }
        }
    }

    // method untuk mencari mahasiswa berdasarkan NIM
    static void cariMahasiswa() {
        System.out.print("Masukkan NIM yang dicari: ");
        String nim = input.nextLine();
        Mahasiswa mhs = getMahasiswaByNim(nim);
        
        if (mhs != null) {
            mhs.tampilData();
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    // method untuk menghitung rata-rata IPK
    static void hitungRataIpk() {
        if (jumlahMhs == 0) {
            System.out.println("Belum ada data mahasiswa!");
            return;
        }

        double totalIpk = 0.0;
        for (int i = 0; i < jumlahMhs; i++) {
            totalIpk += daftarMhs[i].getIpk();
        }

        double rata = totalIpk / jumlahMhs;
        System.out.println("Rata-rata IPK semua mahasiswa: " + String.format("%.2f", rata));
    }

    // method untuk mengganti dosen wali
    static void gantiDosenWali() {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = input.nextLine();
        Mahasiswa mhs = getMahasiswaByNim(nim);

        if (mhs != null) {
            System.out.print("Masukkan nama dosen wali baru: ");
            String namaDosen = input.nextLine();
            System.out.print("Masukkan NIDN dosen: ");
            String nidn = input.nextLine();

            Dosen dosenBaru = new DosenTetap(namaDosen, nidn);
            mhs.setDosenWali(dosenBaru);
            System.out.println("Dosen wali berhasil diganti!");
        } else {
            System.out.println("Mahasiswa tidak ditemukan!");
        }
    }

    // method untuk menambah mahasiswa baru
    static void tambahMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();

        for (int i = 0; i < jumlahMhs; i++) {
            if (daftarMhs[i].getNim().equals(nim)) {
                System.out.println("NIM sudah terdaftar!");
                return;
            }
        }

        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Prodi: ");
        String prodi = input.nextLine();
        
        System.out.print("Masukkan Umur: ");
        if (!input.hasNextInt()) {
            System.out.println("Input Umur tidak valid!");
            input.nextLine();
            return;
        }
        int umur = input.nextInt();
        input.nextLine();
        
        System.out.print("Masukkan IPK (0.0 - 4.0): ");
        String ipkStr = input.nextLine().replace(",", ".");
        double ipk;
        try {
            ipk = Double.parseDouble(ipkStr);
        } catch (NumberFormatException e) {
            System.out.println("Input IPK tidak valid!");
            return;
        }
        
        System.out.print("Masukkan SKKM: ");
        if (!input.hasNextInt()) {
            System.out.println("Input SKKM tidak valid!");
            input.nextLine();
            return;
        }
        int skkm = input.nextInt();
        input.nextLine();

        System.out.print("Masukkan Nama Dosen Wali: ");
        String namaDosen = input.nextLine();
        System.out.print("Masukkan NIDN Dosen Wali: ");
        String nidn = input.nextLine();
        
        Dosen dosenWali = new DosenTetap(namaDosen, nidn);

        Mahasiswa mhsBaru = new MahasiswaReguler(nim, nama, prodi, ipk, skkm, umur);

        if (mhsBaru.getIpk() == null || mhsBaru.getUmur() == null) {
            return;
        }
        
        
        mhsBaru.setDosenWali(dosenWali); 

        daftarMhs[jumlahMhs] = mhsBaru;
        jumlahMhs++;

        System.out.println("Mahasiswa berhasil ditambahkan beserta dosen walinya!");

    }
    
}