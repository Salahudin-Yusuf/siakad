package siakad;

public class MahasiswaReguler extends Mahasiswa{
    private int IdKategoriKelas;

    // Konstruktor default
    public MahasiswaReguler() {
        super();
    }

    // Konstruktor mahasiswa reguler
    public MahasiswaReguler(String nim, String nama, String prodi, Double ipk, Integer skkm, Integer umur) {
        super(nim, nama, prodi, ipk, skkm, umur);
    }

    public int getIdKategoriKelas() {
        return IdKategoriKelas;
    }

    public void setIdKategoriKelas(int IdKategoriKelas) {
        this.IdKategoriKelas = IdKategoriKelas;
    }

    @Override
    public void tampilData(){
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Umur  : " + umur + " tahun");
        System.out.println("Prodi  : " + prodi);
        System.out.println("IPK  : " + String.format("%.2f", ipk));
        System.out.println("SKKM  : " + skkm);
        System.out.println("Predikat Kelulusan : " + predikatKelulusan());
        System.out.println("Dosen Wali  : " + dosenWali.getNama());
        tampilKRS();
    }
}
