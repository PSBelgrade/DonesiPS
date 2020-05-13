package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectClass {

    public Connection connect;


    public boolean connections1(String server, String port, String base, String username, String password) {
        boolean status = false;


        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            connect = DriverManager.getConnection("jdbc:oracle:thin:" + server + ":" + port + ":" + base, username, password);
            if (!connect.isClosed()) {
                status = true;
                System.out.println("Connection is successful!");
            } else {
                System.out.println("Connection unsuccessful!");
            }

        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
        return status;
    }
}