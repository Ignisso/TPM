package bdbt_bada_project.SpringApplication.Database;

import bdbt_bada_project.SpringApplication.DatabseController;

import java.sql.ResultSet;
import java.util.List;

public class TrasaDAO {
    DatabseController dbcon;

    public TrasaDAO() {
        dbcon = new DatabseController();
    }

    public Trasa select(int nr_trasy) {
        String sql = "SELECT * FROM test WHERE id = " + Integer.toString(nr_trasy) + ";";
        ResultSet rs = dbcon.select(sql);
        try {
            if (rs.next()) {

            }
            else
                return null;
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
            return null;
        }
    }

    public void insert(Trasa trasa) {

    }

    public void update(Trasa trasa, int nr_trasy) {

    }

    public void delete(int nr_trasy) {

    }
}
