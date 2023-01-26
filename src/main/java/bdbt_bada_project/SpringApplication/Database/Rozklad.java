package bdbt_bada_project.SpringApplication.Database;

public class Rozklad {
    private int nr_rozkladu;
    private String godzina_odjazdu;
    private int nr_linii;

    public Rozklad(int nr_rozkladu, String godzina_odjazdu, int nr_linii) {
        this.nr_rozkladu     = nr_rozkladu;
        this.godzina_odjazdu = godzina_odjazdu;
        this.nr_linii        = nr_linii;
    }

    public int getNr_rozkladu() {
        return nr_rozkladu;
    }

    public void setNr_rozkladu(int nr_rozkladu) {
        this.nr_rozkladu = nr_rozkladu;
    }

    public String getGodzina_odjazdu() {
        return godzina_odjazdu;
    }

    public void setGodzina_odjazdu(String godzina_odjazdu) {
        this.godzina_odjazdu = godzina_odjazdu;
    }

    public int getNr_linii() {
        return nr_linii;
    }

    public void setNr_linii(int nr_linii) {
        this.nr_linii = nr_linii;
    }

    @Override
    public String toString() {
        return "Rozklad{" +
                "nr_rozkladu=" + nr_rozkladu +
                ", godzina_odjazdu='" + godzina_odjazdu + '\'' +
                ", nr_linii=" + nr_linii +
                '}';
    }
}