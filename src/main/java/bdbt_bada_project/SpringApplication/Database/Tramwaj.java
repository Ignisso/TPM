package bdbt_bada_project.SpringApplication.Database;


public class Tramwaj {
    private int nr_tramwaju;
    private int przebieg;
    private int nr_zajezdni;
    private int nr_modelu;

    public Tramwaj(int nr_tramwaju, int przebieg, int nr_zajezdni, int nr_modelu) {
        this.nr_tramwaju = nr_tramwaju;
        this.przebieg = przebieg;
        this.nr_zajezdni = nr_zajezdni;
        this.nr_modelu = nr_modelu;
    }

    public int getNr_tramwaju() {
        return nr_tramwaju;
    }

    public void setNr_tramwaju(int nr_tramwaju) {
        this.nr_tramwaju = nr_tramwaju;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public int getNr_zajezdni() {
        return nr_zajezdni;
    }

    public void setNr_zajezdni(int nr_zajezdni) {
        this.nr_zajezdni = nr_zajezdni;
    }

    public int getNr_modelu() {
        return nr_modelu;
    }

    public void setNr_modelu(int nr_modelu) {
        this.nr_modelu = nr_modelu;
    }

    @Override
    public String toString() {
        return "Tramwaj{" +
                "nr_tramwaju=" + nr_tramwaju +
                ", przebieg=" + przebieg +
                ", nr_zajezdni=" + nr_zajezdni +
                ", nr_modelu=" + nr_modelu +
                '}';
    }
}