package bdbt_bada_project.SpringApplication.Database;


public class Pasazer {
    private int nr_pasazera;
    private String imie;
    private String nazwisko;
    private String PESEL;
    private int nr_przedsiebiorstwa;

    public Pasazer(int nr_pasazera, String imie, String nazwisko, String PESEL, int nr_przedsiebiorstwa) {
        this.nr_pasazera = nr_pasazera;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.nr_przedsiebiorstwa = nr_przedsiebiorstwa;
    }

    public int getNr_pasazera() {
        return nr_pasazera;
    }

    public void setNr_pasazera(int nr_pasazera) {
        this.nr_pasazera = nr_pasazera;
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

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public int getNr_przedsiebiorstwa() {
        return nr_przedsiebiorstwa;
    }

    public void setNr_przedsiebiorstwa(int nr_przedsiebiorstwa) {
        this.nr_przedsiebiorstwa = nr_przedsiebiorstwa;
    }

    @Override
    public String toString() {
        return "Pasazer{" +
                "nr_pasazera=" + nr_pasazera +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", nr_przedsiebiorstwa=" + nr_przedsiebiorstwa +
                '}';
    }
}