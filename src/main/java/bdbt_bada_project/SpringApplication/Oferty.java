package bdbt_bada_project.SpringApplication;

public class Oferty {

    private int nr_oferty;
    private String nazwa_produktu;
    private float oferowana_cena;
    private String opis;
    private int nr_klienta;

    public int getNr_oferty() {
        return nr_oferty;
    }
    public void setNr_oferty(int nr_oferty) {
        this.nr_oferty = nr_oferty;
    }
    public String getNazwa_produktu() {
        return nazwa_produktu;
    }
    public void setNazwa_produktu(String nazwa_produktu) {
        this.nazwa_produktu = nazwa_produktu;
    }
    public float getOferowana_cena() {
        return oferowana_cena;
    }
    public void setOferowana_cena(float oferowana_cena) {
        this.oferowana_cena = oferowana_cena;
    }
    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }
    public int getNr_klienta() {
        return nr_klienta;
    }
    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
    }

}
