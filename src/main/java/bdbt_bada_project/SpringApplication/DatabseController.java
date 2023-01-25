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
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(getURL(), User, Password);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return connection;
    }

    public DatabseController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void select(String query) throws SQLException {
        Connection connection = establishConnection();
        if (connection == null) {
            return;
        }

        Statement stat = connection.createStatement();
        ResultSet result = stat.executeQuery(query);
        while(result.next()){
            System.out.print("ID: " + result.getString(1));
            System.out.print(", First: " + result.getString(2));
            System.out.println(", Last: " + result.getString(3));
        }
        connection.close();
    }
}
