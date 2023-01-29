package bdbt_bada_project.SpringApplication.Database;

public class Rozklad extends DatabaseObject  {
    public Rozklad(Integer index) {
        super("rozklady");
        fieldNames.put(0, "nr_rozkladu");
        field.add(index);
        fieldNames.put(1, "godzina_odjazdu");
        field.add("");
        fieldNames.put(2, "nr_linii");
        field.add(0);
    }
}