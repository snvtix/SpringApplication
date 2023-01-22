package bdbt_bada_project.SpringApplication;

public class Pracownicy {

    private int nr_pracownika;
    private String imie;
    private String nazwisko;
    private String data_urodzenia;
    private String pesel;
    private String plec;
    private String email;
    private String nr_telefonu;
    private String nr_konta;
    private String data_zatrudnienia;
    private int nr_rozglosni;
    private int nr_studia;

    public Pracownicy() {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.plec = plec;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.nr_konta = nr_konta;
        this.data_zatrudnienia = data_zatrudnienia;
        this.nr_rozglosni = nr_rozglosni;
        this.nr_studia  = nr_studia;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }
    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public String getData_urodzenia() {
        return data_urodzenia;
    }
    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }
    public String getPesel() {
        return pesel;
    }
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    public String getPlec() {
        return plec;
    }
    public void setPlec(String plec) {
        this.plec = plec;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNr_telefonu() {
        return nr_telefonu;
    }
    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }
    public String getNr_konta() {
        return nr_konta;
    }
    public void setNr_konta(String nr_konta) {
        this.nr_konta = nr_konta;
    }
    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }
    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }
    public int getNr_rozglosni() {
        return nr_rozglosni;
    }
    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }
    public int getNr_studia() {
        return nr_studia;
    }
    public void setNr_studia(int nr_studia) {
        this.nr_studia = nr_studia;
    }

    @Override
    public String toString() {
        return "Pracownicy{" +
                "nr_pracownika=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", pesel='" + pesel + '\'' +
                ", plec='" + plec + '\'' +
                ", email='" + email + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", nr_konta='" + nr_konta + '\'' +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", nr_rozglosni=" + nr_rozglosni +
                ", nr_studia=" + nr_studia +
                '}';
    }

}
