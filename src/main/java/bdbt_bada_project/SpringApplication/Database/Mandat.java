package bdbt_bada_project.SpringApplication.Database;

public class Mandat extends DatabaseObject {
    public Mandat() {
        super("mandaty");
        fieldNames.put(0, "nr_mandatu");
        field.add(0);
        fieldNames.put(1, "kwota");
        field.add(1.f);
        fieldNames.put(2, "data");
        field.add(null);
        fieldNames.put(3, "czy_oplacony");
        field.add('?');
        fieldNames.put(4, "opis");
        field.add("");
        fieldNames.put(5, "nr_pasazera");
        field.add(0);
        fieldNames.put(6, "nr_pracownika");
        field.add(0);
    }
}