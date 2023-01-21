package bdbt_bada_project.SpringApplication.Database;

public class Zajezdnia {
    private int nr_zajezdni;
    private String nazwa;
    private int nr_przedsiebiorstwa;

    public Zajezdnia(int nr_zajezdni, String nazwa, int nr_przedsiebiorstwa) {
        this.nr_zajezdni = nr_zajezdni;
        this.nazwa = nazwa;
        this.nr_przedsiebiorstwa = nr_przedsiebiorstwa;
    }

    public int getNr_zajezdni() {
        return nr_zajezdni;
    }

    public void setNr_zajezdni(int nr_zajezdni) {
        this.nr_zajezdni = nr_zajezdni;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getNr_przedsiebiorstwa() {
        return nr_przedsiebiorstwa;
    }

    public void setNr_przedsiebiorstwa(int nr_przedsiebiorstwa) {
        this.nr_przedsiebiorstwa = nr_przedsiebiorstwa;
    }

    @Override
    public String toString() {
        return "Zajezdnia{" +
                "nr_zajezdni=" + nr_zajezdni +
                ", nazwa='" + nazwa + '\'' +
                ", nr_przedsiebiorstwa=" + nr_przedsiebiorstwa +
                '}';
    }
}