package bdbt_bada_project.SpringApplication.Database;

import java.util.Date;
public class Pracownik {
    private int nr_pracownika;
    private String imie;
    private String nazwisko;
    private String PESEL;
    private String nr_konta_bankowego;
    private char plec;
    private Date data_zatrudnienia;
    private Date data_zwolonienia;
    private float wynagrodzenie;
    private String email;
    private String nr_telefonu;
    private int nr_adresu;
    private int nr_przedsiebiorstwa;

    public Pracownik(int nr_pracownika, String imie, String nazwisko, String PESEL, String nr_konta_bankowego, char plec, Date data_zatrudnienia, Date data_zwolonienia, float wynagrodzenie, String email, String nr_telefonu, int nr_adresu, int nr_przedsiebiorstwa) {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.nr_konta_bankowego = nr_konta_bankowego;
        this.plec = plec;
        this.data_zatrudnienia = data_zatrudnienia;
        this.data_zwolonienia = data_zwolonienia;
        this.wynagrodzenie = wynagrodzenie;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.nr_adresu = nr_adresu;
        this.nr_przedsiebiorstwa = nr_przedsiebiorstwa;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getNr_konta_bankowego() {
        return nr_konta_bankowego;
    }

    public void setNr_konta_bankowego(String nr_konta_bankowego) {
        this.nr_konta_bankowego = nr_konta_bankowego;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public Date getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public Date getData_zwolonienia() {
        return data_zwolonienia;
    }

    public void setData_zwolonienia(Date data_zwolonienia) {
        this.data_zwolonienia = data_zwolonienia;
    }

    public float getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(float wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public int getNr_przedsiebiorstwa() {
        return nr_przedsiebiorstwa;
    }

    public void setNr_przedsiebiorstwa(int nr_przedsiebiorstwa) {
        this.nr_przedsiebiorstwa = nr_przedsiebiorstwa;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "nr_pracownika=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", nr_konta_bankowego='" + nr_konta_bankowego + '\'' +
                ", plec=" + plec +
                ", data_zatrudnienia=" + data_zatrudnienia +
                ", data_zwolonienia=" + data_zwolonienia +
                ", wynagrodzenie=" + wynagrodzenie +
                ", email='" + email + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", nr_adresu=" + nr_adresu +
                ", nr_przedsiebiorstwa=" + nr_przedsiebiorstwa +
                '}';
    }
}