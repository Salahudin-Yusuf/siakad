package siakad;

import java.util.ArrayList;
import java.util.List;

public abstract class Mahasiswa {
    // Atribut mahasiswa
    protected String nim;
    protected String nama;
    protected String prodi;
    protected Double ipk;
    protected Integer skkm;
    protected Integer umur;
    
    // Atribut untuk KRS
    private List<MataKuliah> krs;
    private int jumlahKrs;
    protected Dosen dosenWali;
    
    // Konstruktor default
    public Mahasiswa() {
        this.nim = "";
        this.nama = "";
        this.prodi = "";
        this.ipk = 0.0;
        this.skkm = 0;
        this.umur = 0;
        this.dosenWali = null;
    }

    // Konstruktor mahasiswa
    public Mahasiswa(String nim, String nama, String prodi, Double ipk, Integer skkm, Integer umur) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.skkm = skkm;
        this.dosenWali = null;
        this.krs = new ArrayList<>();
        this.jumlahKrs = 0;

        setIpk(ipk); 
        setUmur(umur);
    }
    
    // Getter nim
    public String getNim() {
        return nim;
    }

    // Getter nama
    public String getNama() {
        return nama;
    }

    // Getter prodi
    public String getProdi() {
        return prodi;
    }

    // Getter ipk
    public Double getIpk() {
        return ipk;
    }
    
    // Getter skkm
    public Integer getSkkm() {
        return skkm;
    }

    // Getter dosen wali
    public Dosen getDosenWali() {
        return dosenWali;
    }
    
    // Getter umur
    public Integer getUmur() {
        return umur;
    }

    // Getter KRS
    public List<MataKuliah> getKrs() {
        return krs;
    }

    // Getter jumlah KRS
    public int getJumlahKrs() {
        return jumlahKrs;
    }

    // Setter nim
    public void setNim(String nim) {
        this.nim = nim;
    }

    // Setter nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Setter prodi
    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    // Setter skkm
    public void setSkkm(Integer skkm) {
        this.skkm = skkm;
    }

    // Setter dosen wali
    public void setDosenWali(Dosen dosen) {
        this.dosenWali = dosen;
    }

    // Setter IPK dengan validasi
    public boolean setIpk(Double ipk) {
        if (ipk >= 0.0 && ipk <= 4.0) {
            this.ipk = ipk;
            return true;
        } else {
            System.out.println("Validasi Gagal: IPK harus antara 0.0 - 4.0!");
            return false;
        }
    }
    
    // Setter Umur dengan validasi
    public boolean setUmur(Integer umur) {
        if (umur != null && umur >= 17) {
            this.umur = umur;
            return true;
        } else {
            System.out.println("Validasi Gagal: Umur minimal 17 tahun!");
            return false;
        }
    }
    
    // Method tambahMataKuliah dengan validasi
    public boolean tambahMataKuliah(MataKuliah mk) {
        for (MataKuliah mataKuliah : krs) {
            if (mataKuliah.getKode_matkul().equals(mk.getKode_matkul())) {
                System.out.println("Mata kuliah dengan kode " + mk.getKode_matkul() + " sudah terdaftar!");
                return false;
            }
        }
        
        // Cek total SKS maksimal 24
        int totalSksSaatIni = hitungTotalSKS();

        if (totalSksSaatIni + mk.getSks() > 24) {
            System.out.println("Validasi Gagal: Total SKS melebihi batas maksimal 24!");
            return false;
        }
        
        krs.add(mk);
        jumlahKrs++;
        return true;
    }
    

    // Method hapusMataKuliah
    public boolean hapusMataKuliah(String kode) {
        for (int i = 0; i < krs.size(); i++) {
            if (krs.get(i).getKode_matkul().equals(kode)) {
                krs.remove(i);
                jumlahKrs--;
                return true;
            }
        }
        return false;
    }
    
    // Method hitungTotalSKS
    public int hitungTotalSKS() {
        int total = 0;
        for (MataKuliah mataKuliah : krs) {
            total += mataKuliah.getSks();
        }
        return total;
    }

    // Method tampilKRS
    public void tampilKRS() {
        System.out.println("\n===== KRS Mahasiswa =====");
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
        System.out.println("Dosen Wali : " + dosenWali.getNama());
        System.out.println("\nMata Kuliah Diambil:");
        
        if (krs.isEmpty()) {
            System.out.println("- Belum ada mata kuliah yang diambil -");
        } else {
            for (MataKuliah mk : krs) {
                mk.info(); // Menggunakan method info() dari MataKuliah
            }
        }
        
        System.out.println("Total SKS: " + hitungTotalSKS());
        System.out.println("=========================");
    }

    // Method tampilData() yang disesuaikan
    abstract void tampilData();
    // {
    //     System.out.println("NIM   : " + nim);
    //     System.out.println("Nama  : " + nama);
    //     System.out.println("Umur  : " + umur + " tahun");
    //     System.out.println("Prodi  : " + prodi);
    //     System.out.println("IPK  : " + String.format("%.2f", ipk));
    //     System.out.println("SKKM  : " + skkm);
    //     System.out.println("Predikat Kelulusan : " + predikatKelulusan());
    //     System.out.println("Dosen Wali  : " + dosenWali.getNama());
    //     tampilKRS();
    // }
    
    // Method predikatKelulusan
    public String predikatKelulusan(){
        String predikat;
        if (ipk >= 3.5){
            predikat = "Cumlaude";
        } else if (ipk >= 3.0) {
            predikat = "Baik";
        } else if (ipk >= 2.5) {
            predikat = "Cukup";
        } else {
            predikat = "Kurang";
        } return predikat;
    }

    // Method infoSingkat
    public void infoSingkat(){
        System.out.println("Nama: " + nama + ", NIM: " + nim + ", Prodi: " + prodi + ", Dosen Wali: " + dosenWali.getNama());
    }

    // Method tampilSKKM
    void tampilSKKM(){
        System.out.println("Juumlah SKKM: " + skkm);
        if (skkm >= 32){
            System.out.println("SKKM sudah mencukupi");
            System.out.println("SKKM yang harus ditempuh minimal 32");
        } else {
            System.out.println("SKKM belum mencukupi");
            System.out.println("Kurang " + (32 - skkm) + " SKKM lagi");
            System.out.println("SKKM yang harus ditempuh minimal 32");
        }
    }
}