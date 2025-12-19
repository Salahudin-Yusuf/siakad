package siakad;

public class MataKuliah {
    // Atribut mata kuliah
    private String kode_matkul;
    private String namaMk;
    private int sks;

    // Konstruktor mata kuliah
    public MataKuliah(String kode_matkul, String namaMk, int sks) {
        setKode_matkul(kode_matkul);
        setSks(sks);
        this.namaMk = namaMk;
    }

    // Getter mata kuliah
    public String getKode_matkul() {
        return kode_matkul;
    }

    // Getter namaMk
    public String getNamaMk() {
        return namaMk;
    }

    // Getter sks
    public int getSks() {
        return sks;
    }

    // Setter kode mata kuliah dengan validasi
    public boolean setKode_matkul(String kode_matkul) {
        if (kode_matkul != null && !kode_matkul.trim().isEmpty()) {
            this.kode_matkul = kode_matkul;
            return true;
        } else {
            System.out.println("Validasi Gagal: Kode mata kuliah tidak boleh kosong!");
            return false;
        }
    }

    // Setter namaMk
    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    // Setter sks dengan validasi
    public boolean setSks(int sks) {
        // Validasi: sks harus berada antara 1-6 (1.a.4)
        if (sks >= 1 && sks <= 6) {
            this.sks = sks;
            return true;
        } else {
            System.out.println("Validasi Gagal: SKS harus antara 1-6!");
            return false;
        }
    }

    // Method info
    public void info() {
        System.out.println(kode_matkul + " - " + namaMk + " (" + sks + " SKS)");
    }
}