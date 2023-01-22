package bdbt_bada_project.SpringApplication;

public class Wynagrodzenia {

    private int nr_wynagrodzenia;
    private float brutto;
    private float netto;
    private float tara;
    private int nr_pracownika;
    private int nr_przychodu;

    public Wynagrodzenia() {
        this.nr_wynagrodzenia = nr_wynagrodzenia;
        this.brutto = brutto;
        this.netto = netto;
        this.tara = tara;
        this.nr_pracownika = nr_pracownika;
        this.nr_przychodu = nr_przychodu;
    }

    public int getNr_wynagrodzenia() {
        return nr_wynagrodzenia;
    }
    public void setNr_wynagrodzenia(int nr_wynagrodzenia) {
        this.nr_wynagrodzenia = nr_wynagrodzenia;
    }
    public float getBrutto() {
        return brutto;
    }
    public void setBrutto(float brutto) {
        this.brutto = brutto;
    }
    public float getNetto() {
        return netto;
    }
    public void setNetto(float netto) {
        this.netto = netto;
    }
    public float getTara() {
        return tara;
    }
    public void setTara(float tara) {
        this.tara = tara;
    }
    public int getNr_pracownika() {
        return nr_pracownika;
    }
    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }
    public int getNr_przychodu() {
        return nr_przychodu;
    }
    public void setNr_przychodu(int nr_przychodu) {
        this.nr_przychodu = nr_przychodu;
    }

    @Override
    public String toString() {
        return "Wynagrodzenia{" +
                "Nr_wynagrodzenia=" + nr_wynagrodzenia +
                ", Brutto=" + brutto +
                ", Netto=" + netto +
                ", Tara=" + tara +
                '}';
    }

}

