package bdbt_bada_project.SpringApplication.Database;

public class Mechanik {
    private String specjalizacja;
    private int nr_pracownika;
    private int nr_zajezdni;

    public Mechanik(String specjalizacja, int nr_pracownika, int nr_zajezdni) {
        this.specjalizacja = specjalizacja;
        this.nr_pracownika = nr_pracownika;
        this.nr_zajezdni = nr_zajezdni;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    public int getNr_zajezdni() {
        return nr_zajezdni;
    }

    public void setNr_zajezdni(int nr_zajezdni) {
        this.nr_zajezdni = nr_zajezdni;
    }

    @Override
    public String toString() {
        return "Mechanicy{" +
                "specjalizacja='" + specjalizacja + '\'' +
                ", nr_pracownika=" + nr_pracownika +
                ", nr_zajezdni=" + nr_zajezdni +
                '}';
    }
}