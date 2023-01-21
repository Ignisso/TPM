package bdbt_bada_project.SpringApplication.Database;

import java.util.Date;
public class Przedsiebiorstwo {
    private int nr_przedsiebiorstwa;
    private Date data_zalozenia;
    private int nr_adresu;

    public Przedsiebiorstwo(int nr_przedsiebiorstwa, Date data_zalozenia, int nr_adresu) {
        this.nr_przedsiebiorstwa = nr_przedsiebiorstwa;
        this.data_zalozenia = data_zalozenia;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_przedsiebiorstwa() {
        return nr_przedsiebiorstwa;
    }

    public void setNr_przedsiebiorstwa(int nr_przedsiebiorstwa) {
        this.nr_przedsiebiorstwa = nr_przedsiebiorstwa;
    }

    public Date getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(Date data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Przedsiebiorstwo{" +
                "nr_przedsiebiorstwa=" + nr_przedsiebiorstwa +
                ", data_zalozenia=" + data_zalozenia +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}