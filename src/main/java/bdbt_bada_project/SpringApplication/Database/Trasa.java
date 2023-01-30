package bdbt_bada_project.SpringApplication.Database;

public class Trasa extends DatabaseObject {
    public Trasa() {
        super("trasy");
        fieldNames.put(0, "nr_trasy");
        field.add(0);
        fieldNames.put(1, "kolejnosc");
        field.add(0);
        fieldNames.put(2, "czas");
        field.add(0);
        fieldNames.put(3, "nr_linii");
        field.add(0);
        fieldNames.put(4, "nr_przystanku");
        field.add(0);
    }
}