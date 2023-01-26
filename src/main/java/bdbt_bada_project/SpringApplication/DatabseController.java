package bdbt_bada_project.SpringApplication;

import java.sql.*;

public class DatabseController {
    private String getURL() {
        final String Host     = "localhost";
        final String Port     = "3306";
        final String Database = "test";
        final String Prefix   = "jdbc:mysql://";
        return Prefix + Host + ":" + Port + "/" + Database;
    }

    private Connection establishConnection() {
        final String User     = "root";
        final String Password = "";
        try (Connection connection = DriverManager.getConnection(getURL(), User, Password)) {
            return connection;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
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
        Connection connection = establishConnection();
        if (connection == null)
            return null;
        try (Statement stat = connection.createStatement()) {
            try (ResultSet result = stat.executeQuery(query)) {
                connection.close();
                return result;
            } catch (Exception ex) {
                ex.getMessage();
                ex.printStackTrace();
                return null;
            }
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
            return null;
        }
    }

    public int execute(String sql) {
        Connection connection = establishConnection();
        if (connection == null)
            return -1;
        try (Statement stat = connection.createStatement()) {
            int result = stat.executeUpdate(sql);
            connection.close();
            return result;
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
            return -1;
        }
    }
}
