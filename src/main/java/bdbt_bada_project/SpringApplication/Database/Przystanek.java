package bdbt_bada_project.SpringApplication.Database;

public class Przystanek extends DatabaseObject {
    public Przystanek(Integer index) {
        super("przystanki");
        fieldNames.put(0, "nr_przystanku");
        field.add(index);
        fieldNames.put(1, "nazwa");
        field.add("");
    }
}