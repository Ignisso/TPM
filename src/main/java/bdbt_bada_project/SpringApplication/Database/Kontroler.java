package bdbt_bada_project.SpringApplication.Database;

public class Kontroler extends DatabaseObject {
    public Kontroler(Integer index) {
        super("kontrolerzy");
        fieldNames.put(0, "nr_kontrolera");
        field.add(index);
        fieldNames.put(1, "numer_seryjny_skanera");
        field.add("");
        fieldNames.put(2, "nr_pracownika");
        field.add(0);
    }
}