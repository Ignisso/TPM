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
        nr_biletu = (Integer) field.get(0);
        data_skasowania = (Integer) field.get(1);
        nr_pasazera = (Integer) field.get(2);
        nr_rodzaju_biletu = (Integer) field.get(3);
    }
    private Integer nr_biletu;
    private Integer data_skasowania;
    private Integer nr_pasazera;
    private Integer nr_rodzaju_biletu;
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
    public void setnr_biletu(Integer value) {
         field.set(0, value);
    }
    public void setdata_skasowania(Integer value) {
         field.set(1, value);
    }

    public void setnr_pasazera(Integer value) {
        field.set(2, value);
    }

    public void setnr_rodzaju_biletu(Integer value) {
        field.set(3, value);
    }
}