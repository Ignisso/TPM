package bdbt_bada_project.SpringApplication.Database;

import java.util.Date;

public class Usterka {
    private int nr_usterki;
    private Date data;
    private String opis;
    private String stan;
    private int nr_tramwaju;
    private int nr_pracownika;

    public Usterka(int nr_usterki, Date data, String opis, String stan, int nr_tramwaju, int nr_pracownika) {
        this.nr_usterki = nr_usterki;
        this.data = data;
        this.opis = opis;
        this.stan = stan;
        this.nr_tramwaju = nr_tramwaju;
        this.nr_pracownika = nr_pracownika;
    }

    public int getNr_usterki() {
        return nr_usterki;
    }

    public void setNr_usterki(int nr_usterki) {
        this.nr_usterki = nr_usterki;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public int getNr_tramwaju() {
        return nr_tramwaju;
    }

    public void setNr_tramwaju(int nr_tramwaju) {
        this.nr_tramwaju = nr_tramwaju;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    @Override
    public String toString() {
        return "Usterka{" +
                "nr_usterki=" + nr_usterki +
                ", data=" + data +
                ", opis='" + opis + '\'' +
                ", stan='" + stan + '\'' +
                ", nr_tramwaju=" + nr_tramwaju +
                ", nr_pracownika=" + nr_pracownika +
                '}';
    }
}