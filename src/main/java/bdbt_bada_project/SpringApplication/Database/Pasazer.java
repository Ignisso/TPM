package bdbt_bada_project.SpringApplication.Database;

public class Pasazer extends DatabaseObject {
    public Pasazer() {
        super("pasazerowie");
        fieldNames.put(0, "nr_pasazera");
        field.add(0);
        fieldNames.put(1, "imie");
        field.add("");
        fieldNames.put(2, "nazwisko");
        field.add("");
        fieldNames.put(3, "pesel");
        field.add("");
    }
}