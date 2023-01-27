package bdbt_bada_project.SpringApplication;

import java.sql.*;

public class DatabseController {
    Connection active = null;
    private String getURL() {
        final String Host     = "192.168.0.87";
        final String Port     = "3306";
        final String Database = "tpm";
        final String Prefix   = "jdbc:mysql://";
        return Prefix + Host + ":" + Port + "/" + Database;
    }

    private Connection establishConnection() {
        final String User     = "ignisso";
        final String Password = "fire";
        try (Connection connection = DriverManager.getConnection(getURL(), User, Password)) {
            return connection;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public DatabseController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public ResultSet select(String query) {
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int execute(String sql) {
            return -1;
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
}
