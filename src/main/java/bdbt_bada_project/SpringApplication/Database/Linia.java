package bdbt_bada_project.SpringApplication.Database;

public class Linia {
    private int nr_linii;
    private int linia;
    private boolean czy_zawieszona;

    public Linia(int nr_linii, int linia, char czy_zawieszona) {
        this.nr_linii = nr_linii;
        this.linia = linia;
        this.czy_zawieszona = (czy_zawieszona == 'T');
    }

    public int getNr_linii() {
        return nr_linii;
    }

    public void setNr_linii(int nr_linii) {
        this.nr_linii = nr_linii;
    }

    public int getLinia() {
        return linia;
    }

    public void setLinia(int linia) {
        this.linia = linia;
    }

    public boolean isCzy_zawieszona() {
        return czy_zawieszona;
    }

    public void setCzy_zawieszona(boolean czy_zawieszona) {
        this.czy_zawieszona = czy_zawieszona;
    }

    @Override
    public String toString() {
        return "Linia{" +
                "nr_linii=" + nr_linii +
                ", linia=" + linia +
                ", czy_zawieszona=" + czy_zawieszona +
                '}';
    }
}