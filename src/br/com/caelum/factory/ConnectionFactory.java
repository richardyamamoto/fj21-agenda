package br.com.caelum.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        String database = "jdbc:mysql://localhost/fj21";
        String user = "root";
        String password = "000000";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "000000");
        }catch (SQLException | ClassNotFoundException err) {
            throw new RuntimeException(err);
        }
    }
}
