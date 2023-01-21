package bdbt_bada_project.SpringApplication.Database;

public class Kierujacy {
    private int nr_tramwaju;
    private int nr_pracownika;
    private int data_od;
    private int data_do;

    public Kierujacy(int nr_tramwaju, int nr_pracownika, int data_od, int data_do) {
        this.nr_tramwaju = nr_tramwaju;
        this.nr_pracownika = nr_pracownika;
        this.data_od = data_od;
        this.data_do = data_do;
    }

    public int getNr_tramwaju() {
        return nr_tramwaju;
    }

    public void setNr_tramwaju(int nr_tramwaju) {
        this.nr_tramwaju = nr_tramwaju;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
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
        return "Kierujacy{" +
                "nr_tramwaju=" + nr_tramwaju +
                ", nr_pracownika=" + nr_pracownika +
                ", data_od=" + data_od +
                ", data_do=" + data_do +
                '}';
    }
}