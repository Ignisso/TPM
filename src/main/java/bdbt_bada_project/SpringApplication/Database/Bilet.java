package bdbt_bada_project.SpringApplication.Database;

public class Bilet extends DatabaseObject {
    public Bilet() {
        super("bilety");
        fieldNames.put(0, "nr_biletu");
        field.add(0);
        fieldNames.put(1, "data_skasowania");
        field.add(null);
        fieldNames.put(2, "nr_pasazera");
        field.add(0);
        fieldNames.put(3, "nr_rodzaju_biletu");
        field.add(0);
    }
}