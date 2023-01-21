package bdbt_bada_project.SpringApplication.Database;

public class Kontroler {
    private int nr_kontrolera;
    private String numer_seryjny_skanera;
    private int nr_pracownika;

    public Kontroler(int nr_kontrolera, String numer_seryjny_skanera, int nr_pracownika) {
        this.nr_kontrolera = nr_kontrolera;
        this.numer_seryjny_skanera = numer_seryjny_skanera;
        this.nr_pracownika = nr_pracownika;
    }

    public int getNr_kontrolera() {
        return nr_kontrolera;
    }

    public void setNr_kontrolera(int nr_kontrolera) {
        this.nr_kontrolera = nr_kontrolera;
    }

    public String getNumer_seryjny_skanera() {
        return numer_seryjny_skanera;
    }

    public void setNumer_seryjny_skanera(String numer_seryjny_skanera) {
        this.numer_seryjny_skanera = numer_seryjny_skanera;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    @Override
    public String toString() {
        return "Kontroler{" +
                "nr_kontrolera=" + nr_kontrolera +
                ", numer_seryjny_skanera='" + numer_seryjny_skanera + '\'' +
                ", nr_pracownika=" + nr_pracownika +
                '}';
    }
}