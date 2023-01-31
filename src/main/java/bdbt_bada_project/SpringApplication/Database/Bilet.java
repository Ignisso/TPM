package bdbt_bada_project.SpringApplication.Database;

import java.util.Date;

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

    public Integer getnr_biletu() {
        return (Integer)field.get(0);
    }

    public Date getdata_skasowania() {
        return (Date)field.get(1);
    }

    public Integer getnr_pasazera() {
        return (Integer)field.get(2);
    }

    public Integer getnr_rodzaju_biletu() {
        return (Integer)field.get(3);
    }
}