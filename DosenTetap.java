package siakad;

class DosenTetap extends Dosen implements KelolaDataAkademik{
    public DosenTetap(String nama, String nidn) {
        super(nama, nidn);
        this.status_dosen = "Dosen Tetap";
    }

    @Override
    public void absen() {
        System.out.println("Dosen Tetap " + nama + " melakukan absen melalui Fingerprint.");
    }

    @Override
    public void tambahData() {
        System.out.println("Dosen " + nama + " menambahkan data nilai mahasiswa.");
    }

    @Override
    public void ubahData() {
        System.out.println("Dosen " + nama + " mengubah data akademik.");
    }

}

class DosenLB extends Dosen {
    public DosenLB(String nama) {
        super(nama);
        this.status_dosen = "Dosen Luar Biasa";
    }

    @Override
    public void absen() {
        System.out.println("Dosen LB " + nama + " melakukan absen melalui Tanda Tangan.");
    }
}