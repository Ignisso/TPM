package bdbt_bada_project.SpringApplication.Database;


public class Model {
    private int nr_modelu;
    private String nazwa_modelu;
    private int ilosc_miejsc;
    private int ilosc_miejsc_stojacych;
    private boolean czy_niskopodlogowy;
    private boolean czy_klimatyzacja;

    public Model(int nr_modelu, String nazwa_modelu, int ilosc_miejsc, int ilosc_miejsc_stojacych, char czy_niskopodlogowy, char czy_klimatyzacja) {
        this.nr_modelu = nr_modelu;
        this.nazwa_modelu = nazwa_modelu;
        this.ilosc_miejsc = ilosc_miejsc;
        this.ilosc_miejsc_stojacych = ilosc_miejsc_stojacych;
        this.czy_niskopodlogowy = (czy_niskopodlogowy == 'T');
        this.czy_klimatyzacja = (czy_klimatyzacja == 'T');
    }

    public int getNr_modelu() {
        return nr_modelu;
    }

    public void setNr_modelu(int nr_modelu) {
        this.nr_modelu = nr_modelu;
    }

    public String getNazwa_modelu() {
        return nazwa_modelu;
    }

    public void setNazwa_modelu(String nazwa_modelu) {
        this.nazwa_modelu = nazwa_modelu;
    }

    public int getIlosc_miejsc() {
        return ilosc_miejsc;
    }

    public void setIlosc_miejsc(int ilosc_miejsc) {
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public int getIlosc_miejsc_stojacych() {
        return ilosc_miejsc_stojacych;
    }

    public void setIlosc_miejsc_stojacych(int ilosc_miejsc_stojacych) {
        this.ilosc_miejsc_stojacych = ilosc_miejsc_stojacych;
    }

    public boolean isCzy_niskopodlogowy() {
        return czy_niskopodlogowy;
    }

    public void setCzy_niskopodlogowy(boolean czy_niskopodlogowy) {
        this.czy_niskopodlogowy = czy_niskopodlogowy;
    }

    public boolean isCzy_klimatyzacja() {
        return czy_klimatyzacja;
    }

    public void setCzy_klimatyzacja(boolean czy_klimatyzacja) {
        this.czy_klimatyzacja = czy_klimatyzacja;
    }

    @Override
    public String toString() {
        return "Model{" +
                "nr_modelu=" + nr_modelu +
                ", nazwa_modelu='" + nazwa_modelu + '\'' +
                ", ilosc_miejsc=" + ilosc_miejsc +
                ", ilosc_miejsc_stojacych=" + ilosc_miejsc_stojacych +
                ", czy_niskopodlogowy=" + czy_niskopodlogowy +
                ", czy_klimatyzacja=" + czy_klimatyzacja +
                '}';
    }
}