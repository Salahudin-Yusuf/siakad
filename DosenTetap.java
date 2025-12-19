package siakad;

class DosenTetap extends Dosen {
    public DosenTetap(String nama, String nidn) {
        super(nama, nidn);
        this.status_dosen = "Dosen Tetap";
    }

    @Override
    public void absen() {
        System.out.println("Dosen Tetap " + nama + " melakukan absen melalui Fingerprint.");
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