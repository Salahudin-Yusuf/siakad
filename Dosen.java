package siakad;


public abstract class Dosen {
    // atribut dosen
	String nama;
    String nidn;
    String email;
    String prodi;
    String status_dosen;

    // konstruktor default dosen
    public Dosen() {
        this.nidn = "";
        this.nama = "";
        this.prodi = "";
        this.status_dosen = "";
    }

    
    // konstruktor dosen
    public Dosen(String nama, String nidn, String email, String prodi, String status_dosen) {
        this.nama = nama;
        this.nidn = nidn;
        this.email = email;
        this.prodi = prodi;
        this.status_dosen = status_dosen;
    }
    
    // konstruktor dosen dengan nama dan nidn saja
    public Dosen(String nama, String nidn) {
        this.nama = nama;
        this.nidn = nidn;
        this.prodi = "";
        this.status_dosen = "";
    }
    
    public Dosen(String nama) {
        this.nama = nama;
    }
    
    // method menampilkan data dosen
    void tampilDataDosen(){
        System.out.println("NIDN   : " + nidn);
        System.out.println("Nama  : " + nama);
        System.out.println("Prodi  : " + prodi);
        System.out.println("Email  : " + email);
        System.out.println("Status Dosen  : " + status_dosen);
    }
    
    // getter nama dosen
    public String getNama() {
        return nama;
    }

    // method absen
    public abstract void absen();

    // setter nama dosen
    public void setNama(String nama) {
        this.nama = nama;
    }

}
