package bdbt_bada_project.SpringApplication;

import java.sql.*;

public class DatabaseController {
    private Connection active = null;
    private String lastSql;
    private String getURL() {
        final String Host     = "192.168.0.87";
        final String Port     = "3306";
        final String Database = "tpm";
        final String Prefix   = "jdbc:mysql://";
        return Prefix + Host + ":" + Port + "/" + Database;
    }

    private void establishConnection() {
        final String User     = "ignisso";
        final String Password = "fire";
        try {
            active = DriverManager.getConnection(getURL(), User, Password);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public DatabaseController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public ResultSet select(String query) {
        lastSql = query;
        establishConnection();
        if (active == null)
            return null;
        try {
            Statement stat = active.createStatement();
            return stat.executeQuery(query);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int execute(String sql) {
        lastSql = sql;
        establishConnection();
        if (active == null)
            return -1;
        try {
            Statement stat = active.createStatement();
            int r = stat.executeUpdate(sql);
            //active.commit();
            return r;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public void closeConnection() {
        try {
            if (active != null)
                active.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getLastSql() {
        return lastSql;
    }
}

