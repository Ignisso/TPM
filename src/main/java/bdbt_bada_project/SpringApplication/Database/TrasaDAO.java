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

    public List<Trasa> select(String reg) {
        String sql = "SELECT * FROM trasy " + reg;
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
    }

    public void insert(Trasa trasa) {
        String sql = "INSERT INTO trasy values(" +
                trasa.getNr_trasy() +
                trasa.getKolejnosc() +
                trasa.getCzas() +
                trasa.getNr_linii() +
                trasa.getNr_przystanku() + ")";
        try {
            dbcon.execute(sql);
            dbcon.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(Trasa trasa) {
        String sql = "UPDATE trasy SET kolejnosc = " + trasa.getKolejnosc() +
                ", czas = " + trasa.getCzas() +
                ", nr_linii = " + trasa.getNr_linii() +
                ", nr_przystanku" + trasa.getNr_przystanku() +
                "WHERE nr_trasy = " + trasa.getNr_trasy();
        try {
            dbcon.execute(sql);
            dbcon.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Trasa trasa) {
        String sql = "DELETE FROM trasy WHERE nr_trasy = " + trasa.getNr_trasy();
        try {
            dbcon.execute(sql);
            dbcon.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
