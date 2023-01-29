package bdbt_bada_project.SpringApplication.Database;

import bdbt_bada_project.SpringApplication.DatabseController;
import java.sql.ResultSet;

public class DAO {
    DatabseController dbcon;

    public DAO() {
        dbcon = new DatabseController();
    }

    public void select(DatabaseObject object) {
        String sql = "SELECT * FROM " + object.getTableName() + " WHERE " +
            object.getFieldName(0) + " = " + object.getField(0);
        try {
            ResultSet rs = dbcon.select(sql);
            if (rs.next()) {
                for (int i = 1; i < object.getFieldsNumber(); i++)
                    object.updateField(i, rs.getObject(i + 1));
            }
            dbcon.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insert(DatabaseObject object) {
        String sql = "INSERT INTO " + object.getTableName() + " values("
                + object.getField(0);
        for (int i = 1; i < object.getFieldsNumber(); i++) {
            sql += ", " + object.getField(i);
        }
        sql += ")";
        try {
            dbcon.execute(sql);
            dbcon.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(DatabaseObject object) {
        String sql = "UPDATE " + object.getTableName() + " SET " +
                object.getFieldName(1) + " = " + object.getField(1);
        for (int i = 2; i < object.getFieldsNumber(); i++) {
            sql += ", " + object.getFieldName(i) + " = " + object.getField(i);
        }
        sql += " WHERE " + object.getFieldName(0) + " = " + object.getField(0);
        try {
            dbcon.execute(sql);
            dbcon.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(DatabaseObject object) {
        String sql = "DELETE FROM " + object.getTableName() + " WHERE " +
                object.getFieldName(0) + " = " + object.getField(0);
        try {
            dbcon.execute(sql);
            dbcon.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}