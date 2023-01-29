package bdbt_bada_project.SpringApplication.Database;

public class Pracownik extends DatabaseObject {
    public Pracownik(Integer index) {
        super("pracownicy");
        fieldNames.put(0, "nr_pracownika");
        field.add(index);
        fieldNames.put(1, "imie");
        field.add("");
        fieldNames.put(2, "nazwisko");
        field.add("");
        fieldNames.put(3, "pesel");
        field.add("");
        fieldNames.put(4, "nr_konta_bankowego");
        field.add("");
        fieldNames.put(5, "plec");
        field.add('?');
        fieldNames.put(6, "data_zatrudnienia");
        field.add(null);
        fieldNames.put(7, "data_zwolnienia");
        field.add(null);
        fieldNames.put(8, "wynagrodzenie");
        field.add(0.f);
        fieldNames.put(9, "email");
        field.add("");
        fieldNames.put(10, "nr_telefonu");
        field.add("");
    }
}