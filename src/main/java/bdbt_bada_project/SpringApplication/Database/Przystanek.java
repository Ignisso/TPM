package bdbt_bada_project.SpringApplication.Database;

public class Przystanek {
    private int nr_przystanku;
    private String nazwa;
    private int nr_przedsiebiorstwa;

    public Przystanek(int nr_przystanku, String nazwa, int nr_przedsiebiorstwa) {
        this.nr_przystanku       = nr_przystanku;
        this.nazwa               = nazwa;
        this.nr_przedsiebiorstwa = nr_przedsiebiorstwa;
    }

    public int getNr_przystanku() {
        return nr_przystanku;
    }

    public void setNr_przystanku(int nr_przystanku) {
        this.nr_przystanku = nr_przystanku;
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
        return "Przystanek{" +
                "nr_przystanku=" + nr_przystanku +
                ", nazwa='" + nazwa + '\'' +
                ", nr_przedsiebiorstwa=" + nr_przedsiebiorstwa +
                '}';
    }
}