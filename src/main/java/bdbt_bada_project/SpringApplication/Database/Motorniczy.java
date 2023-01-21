package bdbt_bada_project.SpringApplication.Database;

import java.util.Date;

public class Motorniczy {
    private String nr_prawa_jazdy;
    private Date data_badan;
    private int nr_pracownika;

    public Motorniczy(String nr_prawa_jazdy, Date data_badan, int nr_pracownika) {
        this.nr_prawa_jazdy = nr_prawa_jazdy;
        this.data_badan = data_badan;
        this.nr_pracownika = nr_pracownika;
    }

    public String getNr_prawa_jazdy() {
        return nr_prawa_jazdy;
    }

    public void setNr_prawa_jazdy(String nr_prawa_jazdy) {
        this.nr_prawa_jazdy = nr_prawa_jazdy;
    }

    public Date getData_badan() {
        return data_badan;
    }

    public void setData_badan(Date data_badan) {
        this.data_badan = data_badan;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    @Override
    public String toString() {
        return "Motorniczy{" +
                "nr_prawa_jazdy='" + nr_prawa_jazdy + '\'' +
                ", data_badan=" + data_badan +
                ", nr_pracownika=" + nr_pracownika +
                '}';
    }
}