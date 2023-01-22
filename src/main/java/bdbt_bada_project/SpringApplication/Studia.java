package bdbt_bada_project.SpringApplication;

public class Studia {

    private int nr_studia;
    private String nazwa;
    private String powierzchnia;
    private int nr_rozglosni;

    public Studia() {
        this.nr_studia = nr_studia;
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
        this.nr_rozglosni = nr_rozglosni;
    }

    public int getNr_studia() {
        return nr_studia;
    }
    public void setNr_studia(int nr_studia) {
        this.nr_studia = nr_studia;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getPowierzchnia() {
        return powierzchnia;
    }
    public void setPowierzchnia(String powierzchnia) {
        powierzchnia = powierzchnia;
    }
    public int getNr_rozglosni() {
        return nr_rozglosni;
    }
    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }

    @Override
    public String toString() {
        return "Studia{" +
                "nr_studia=" + nr_studia +
                ", nazwa='" + nazwa + '\'' +
                ", powierzchnia='" + powierzchnia + '\'' +
                ", nr_rozglosni=" + nr_rozglosni +
                '}';
    }

}
