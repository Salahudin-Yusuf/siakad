package siakad;

public class DosenLB extends Dosen{
    private String nama;

    public DosenLB(String nama) {
        super(nama);
    }

    @Override
    public void absen() {
        System.out.println(super.getNama() + " melakukan absensi.");
    }
}