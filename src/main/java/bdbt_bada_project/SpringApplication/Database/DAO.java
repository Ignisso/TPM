package bdbt_bada_project.SpringApplication.Database;

import bdbt_bada_project.SpringApplication.DatabaseController;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO<T extends DatabaseObject> {
    DatabaseController dbcon;

    public DAO() {
        dbcon = new DatabaseController();
    }

    /**
     * Selects from database multiple rows from table specified by argument <b>fields</b> of argument <b>info</b>.
     * Then return all database objects read from database.
     */
    public List<T> selectByFieldsName(T info, String[] fields) {
        String sql = "SELECT * FROM " + info.getTableName();
        if (fields != null) {
            sql += " WHERE ";
            for (int i = 1; i < fields.length; i++) {
                sql += fields[i] + " = " + info.getField(fields[i]) + " AND ";
            }
            if (fields.length >= 1)
                sql += fields[0] + " = " + info.getField(fields[0]);
        }
        try {
            ResultSet rs = dbcon.select(sql);
            List<T> result = new ArrayList<>();
            Class c = info.getClass();
            while (rs.next()) {
                T f = (T)c.getDeclaredConstructor().newInstance();
                result.add(f);
                for (int i = 0; i < info.getFieldsNumber(); i++)
                    result.get(result.size() - 1).updateField(i, rs.getObject(i + 1));
            }
            dbcon.closeConnection();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Selects from database multiple rows from table specified by argument <b>fields</b> of argument <b>info</b>.
     * Then return all database objects read from database.
     */
    public List<T> selectByFieldsNumber(T info, Integer... fields) {
        String sql = "SELECT * FROM " + info.getTableName();
        if (fields != null) {
            sql += " WHERE ";
            for (int i = 0; i < fields.length - 1; i++) {
                sql += info.getFieldName(fields[i]) + " = " + info.getField(fields[i]) + " AND ";
            }
            if (fields.length > 2)
                sql += info.getFieldName(fields[fields.length - 1]) + " = " + info.getField(fields[fields.length - 1]);
        }
        try {
            ResultSet rs = dbcon.select(sql);
            List<T> result = new ArrayList<>();
            Class c = info.getClass();
            while (rs.next()) {
                T f = (T)c.getDeclaredConstructor().newInstance();
                result.add(f);
                for (int i = 0; i < info.getFieldsNumber(); i++)
                    result.get(result.size() - 1).updateField(i, rs.getObject(i + 1));
            }
            dbcon.closeConnection();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Selects from database all rows from table specified by argument <b>fields</b> of argument <b>info</b>.
     * Then return all database objects read from database.
     */
    public List<T> selectAll(T info) {
        return selectByFieldsNumber(info, null);
    }

    /**
     * Selects from database single row from table specified by primary key of argument <b>object</b>, then assign
     * to object fields values from table.
     */
    public void select(T object) {
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

    /**
     * Inserts into database <b>object</b>.
     */
    public void insert(T object) {
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

    /**
     * Updates database with value <b>object</b>.
     */
    public void update(T object) {
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

    /**
     * Deletes from database <b>object</b>.
     */
    public void delete(T object) {
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