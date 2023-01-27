package bdbt_bada_project.SpringApplication.Database;

public class Trasa {
    private int nr_trasy;
    private int kolejnosc;
    private int czas;
    private int nr_linii;
    private int nr_przystanku;

    public Trasa(int nr_trasy, int kolejnosc, int czas, int nr_linii, int nr_przystanku) {
        this.nr_trasy      = nr_trasy;
        this.kolejnosc     = kolejnosc;
        this.czas          = czas;
        this.nr_linii      = nr_linii;
        this.nr_przystanku = nr_przystanku;
    }

    public int getNr_trasy() {
        return nr_trasy;
    }

    public void setNr_trasy(int nr_trasy) {
        this.nr_trasy = nr_trasy;
    }

    public int getKolejnosc() {
        return kolejnosc;
    }

    public void setKolejnosc(int koljenosc) {
        this.kolejnosc = koljenosc;
    }

    public int getCzas() {
        return czas;
    }

    public void setCzas(int czas) {
        this.czas = czas;
    }

    public int getNr_linii() {
        return nr_linii;
    }

    public void setNr_linii(int nr_linii) {
        this.nr_linii = nr_linii;
    }

    public int getNr_przystanku() {
        return nr_przystanku;
    }

    public void setNr_przystanku(int nr_przystanku) {
        this.nr_przystanku = nr_przystanku;
    }

    @Override
    public String toString() {
        return "Trasa{" +
                "nr_trasy=" + nr_trasy +
                ", kolejnosc=" + kolejnosc +
                ", czas=" + czas +
                ", nr_linii=" + nr_linii +
                ", nr_przystanku=" + nr_przystanku +
                '}';
    }
}