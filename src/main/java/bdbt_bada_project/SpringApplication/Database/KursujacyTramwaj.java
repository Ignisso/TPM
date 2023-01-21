package bdbt_bada_project.SpringApplication.Database;

public class KursujacyTramwaj {
    private int nr_tramwaju;
    private int nr_linii;
    private int data_od;
    private int data_do;

    public KursujacyTramwaj(int nr_tramwaju, int nr_linii, int data_od, int data_do) {
        this.nr_tramwaju = nr_tramwaju;
        this.nr_linii = nr_linii;
        this.data_od = data_od;
        this.data_do = data_do;
    }

    public int getNr_tramwaju() {
        return nr_tramwaju;
    }

    public void setNr_tramwaju(int nr_tramwaju) {
        this.nr_tramwaju = nr_tramwaju;
    }

    public int getNr_linii() {
        return nr_linii;
    }

    public void setNr_linii(int nr_linii) {
        this.nr_linii = nr_linii;
    }

    public int getData_od() {
        return data_od;
    }

    public void setData_od(int data_od) {
        this.data_od = data_od;
    }

    public int getData_do() {
        return data_do;
    }

    public void setData_do(int data_do) {
        this.data_do = data_do;
    }

    @Override
    public String toString() {
        return "KursujacyTramwaj{" +
                "nr_tramwaju=" + nr_tramwaju +
                ", nr_linii=" + nr_linii +
                ", data_od=" + data_od +
                ", data_do=" + data_do +
                '}';
    }
}