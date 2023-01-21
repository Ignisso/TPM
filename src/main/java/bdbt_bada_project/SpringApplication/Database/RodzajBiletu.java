package bdbt_bada_project.SpringApplication.Database;


public class RodzajBiletu {
    private int nr_rodzaju_biletu;
    private boolean czy_ulgowy;
    private String nazwa_biletu;
    private int czas;
    private float cena;

    public RodzajBiletu(int nr_rodzaju_biletu, char czy_ulgowy, String nazwa_biletu, int czas, float cena) {
        this.nr_rodzaju_biletu = nr_rodzaju_biletu;
        this.czy_ulgowy = (czy_ulgowy == 'T');
        this.nazwa_biletu = nazwa_biletu;
        this.czas = czas;
        this.cena = cena;
    }

    public int getNr_rodzaju_biletu() {
        return nr_rodzaju_biletu;
    }

    public void setNr_rodzaju_biletu(int nr_rodzaju_biletu) {
        this.nr_rodzaju_biletu = nr_rodzaju_biletu;
    }

    public boolean isCzy_ulgowy() {
        return czy_ulgowy;
    }

    public void setCzy_ulgowy(boolean czy_ulgowy) {
        this.czy_ulgowy = czy_ulgowy;
    }

    public String getNazwa_biletu() {
        return nazwa_biletu;
    }

    public void setNazwa_biletu(String nazwa_biletu) {
        this.nazwa_biletu = nazwa_biletu;
    }

    public int getCzas() {
        return czas;
    }

    public void setCzas(int czas) {
        this.czas = czas;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "RodzajBiletu{" +
                "nr_rodzaju_biletu=" + nr_rodzaju_biletu +
                ", czy_ulgowy=" + czy_ulgowy +
                ", nazwa_biletu='" + nazwa_biletu + '\'' +
                ", czas=" + czas +
                ", cena=" + cena +
                '}';
    }
}