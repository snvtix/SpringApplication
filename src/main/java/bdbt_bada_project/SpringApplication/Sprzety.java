package bdbt_bada_project.SpringApplication;

import java.time.LocalDate;

public class Sprzety {

    private int nr_sprzetu;
    private String nazwa;
    private String model;
    private String data_zakupu;
    private int nr_rozglosni;
    private int nr_studia;
    private int nr_firmy;

    public int getNr_sprzetu() {
        return nr_sprzetu;
    }
    public void setNr_sprzetu(int nr_sprzetu) {
        this.nr_sprzetu = nr_sprzetu;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getData_zakupu() {
        return data_zakupu;
    }
    public void setData_zakupu(String data_zakupu) {
        this.data_zakupu = data_zakupu;
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
    public int getNr_firmy() {
        return nr_firmy;
    }
    public void setNr_firmy(int nr_firmy) {
        this.nr_firmy = nr_firmy;
    }

}
