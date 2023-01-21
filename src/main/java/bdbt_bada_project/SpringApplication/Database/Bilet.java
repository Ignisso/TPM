package bdbt_bada_project.SpringApplication.Database;

import java.util.Date;

public class Bilet {
    private int nr_biletu;
    private Date data_skasowania;
    private int nr_pasazera;
    private int nr_rodzaju_biletu;

    public Bilet(int nr_biletu, Date data_skasowania, int nr_pasazera, int nr_rodzaju_biletu) {
        this.nr_biletu = nr_biletu;
        this.data_skasowania = data_skasowania;
        this.nr_pasazera = nr_pasazera;
        this.nr_rodzaju_biletu = nr_rodzaju_biletu;
    }

    public int getNr_biletu() {
        return nr_biletu;
    }

    public void setNr_biletu(int nr_biletu) {
        this.nr_biletu = nr_biletu;
    }

    public Date getData_skasowania() {
        return data_skasowania;
    }

    public void setData_skasowania(Date data_skasowania) {
        this.data_skasowania = data_skasowania;
    }

    public int getNr_pasazera() {
        return nr_pasazera;
    }

    public void setNr_pasazera(int nr_pasazera) {
        this.nr_pasazera = nr_pasazera;
    }

    public int getNr_rodzaju_biletu() {
        return nr_rodzaju_biletu;
    }

    public void setNr_rodzaju_biletu(int nr_rodzaju_biletu) {
        this.nr_rodzaju_biletu = nr_rodzaju_biletu;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "nr_biletu=" + nr_biletu +
                ", data_skasowania=" + data_skasowania +
                ", nr_pasazera=" + nr_pasazera +
                ", nr_rodzaju_biletu=" + nr_rodzaju_biletu +
                '}';
    }
}