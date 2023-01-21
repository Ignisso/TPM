package bdbt_bada_project.SpringApplication.Database;

import java.util.Date;

public class Mandat {
    private int nr_mandatu;
    private float kwota;
    private Date data;
    private boolean czy_oplacony;
    private String opis;
    private int nr_pasazera;
    private int nr_pracownika;

    public Mandat(int nr_mandatu, float kwota, Date data, char czy_oplacony, String opis, int nr_pasazera, int nr_pracownika) {
        this.nr_mandatu = nr_mandatu;
        this.kwota = kwota;
        this.data = data;
        this.czy_oplacony = (czy_oplacony == 'T');
        this.opis = opis;
        this.nr_pasazera = nr_pasazera;
        this.nr_pracownika = nr_pracownika;
    }

    public int getNr_mandatu() {
        return nr_mandatu;
    }

    public void setNr_mandatu(int nr_mandatu) {
        this.nr_mandatu = nr_mandatu;
    }

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isCzy_oplacony() {
        return czy_oplacony;
    }

    public void setCzy_oplacony(boolean czy_oplacony) {
        this.czy_oplacony = czy_oplacony;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getNr_pasazera() {
        return nr_pasazera;
    }

    public void setNr_pasazera(int nr_pasazera) {
        this.nr_pasazera = nr_pasazera;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    @Override
    public String toString() {
        return "Mandat{" +
                "nr_mandatu=" + nr_mandatu +
                ", kwota=" + kwota +
                ", data=" + data +
                ", czy_oplacony=" + czy_oplacony +
                ", opis='" + opis + '\'' +
                ", nr_pasazera=" + nr_pasazera +
                ", nr_pracownika=" + nr_pracownika +
                '}';
    }
}