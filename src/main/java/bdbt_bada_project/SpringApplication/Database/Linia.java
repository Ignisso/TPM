package bdbt_bada_project.SpringApplication.Database;

public class Linia extends DatabaseObject {
    public Linia(Integer index) {
        super("linie");
        fieldNames.put(0, "nr_linii");
        field.add(index);
        fieldNames.put(1, "linia");
        field.add("");
        fieldNames.put(2, "czy_zawieszona");
        field.add('?');
    }
}