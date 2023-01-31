package bdbt_bada_project.SpringApplication.Database;

public class Przystanek extends DatabaseObject {
    public Przystanek() {
        super("przystanki");
        fieldNames.put(0, "nr_przystanku");
        field.add(0);
        fieldNames.put(1, "nazwa");
        field.add("");
        nr_przystanku = (Integer) field.get(0);
        nazwa = (String) field.get(1);
    }
    private Integer nr_przystanku;
    private String nazwa;
    public Integer getnr_przystanku() {
        return (Integer) field.get(0);
    }
    public String getnazwa() {
        return (String) field.get(1);
    }

    public void setnr_przystanku(Integer value) {
        field.set(0, value);
    }
    public void setnazwa(String value) {
        field.set(1, value);
    }
}