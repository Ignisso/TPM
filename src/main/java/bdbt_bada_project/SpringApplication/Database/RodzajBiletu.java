package bdbt_bada_project.SpringApplication.Database;

public class RodzajBiletu extends DatabaseObject {
    public RodzajBiletu() {
        super("rodzaje_biletow");
        fieldNames.put(0, "nr_rodzaju_biletu");
        field.add(0);
        fieldNames.put(1, "czy_ulgowy");
        field.add('?');
        fieldNames.put(2, "nazwa_biletu");
        field.add("");
        fieldNames.put(3, "czas");
        field.add(0);
        fieldNames.put(4, "cena");
        field.add(0.f);
    }
}