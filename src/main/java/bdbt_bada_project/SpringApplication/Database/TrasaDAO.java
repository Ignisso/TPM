package bdbt_bada_project.SpringApplication.Database;

import bdbt_bada_project.SpringApplication.DatabseController;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrasaDAO {
    DatabseController dbcon;

    public TrasaDAO() {
        dbcon = new DatabseController();
    }

    public List<Trasa> select(int nr_trasy) {
        String sql = "SELECT * FROM trasy WHERE nr_trasy = " + nr_trasy;
        try {
        ResultSet rs = dbcon.select(sql);
            List<Trasa> result = new ArrayList<>();
            while (rs.next()) {
                Trasa t = new Trasa(
                        rs.getInt("nr_trasy"),
                        rs.getInt("kolejnosc"),
                        rs.getInt("czas"),
                        rs.getInt("nr_linii"),
                        rs.getInt("nr_przystanku"));
                result.add(t);
            }
            dbcon.closeConnection();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    public void insert(Trasa trasa) {

    }

    public void update(Trasa trasa, int nr_trasy) {

    }

    public void delete(int nr_trasy) {

    }
}
