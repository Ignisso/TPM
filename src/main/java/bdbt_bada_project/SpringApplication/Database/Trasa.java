package bdbt_bada_project.SpringApplication.Database;

public class Trasa {
    private int nr_trasy;
    private int koljenosc;
    private int czas;
    private int nr_linii;
    private int nr_przystanku;

    public Trasa(int nr_trasy, int koljenosc, int czas, int nr_linii, int nr_przystanku) {
        this.nr_trasy      = nr_trasy;
        this.koljenosc     = koljenosc;
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

    public int getKoljenosc() {
        return koljenosc;
    }

    public void setKoljenosc(int koljenosc) {
        this.koljenosc = koljenosc;
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
                ", koljenosc=" + koljenosc +
                ", czas=" + czas +
                ", nr_linii=" + nr_linii +
                ", nr_przystanku=" + nr_przystanku +
                '}';
    }
}