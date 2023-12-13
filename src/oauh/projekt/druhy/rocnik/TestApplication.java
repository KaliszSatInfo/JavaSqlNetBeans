package oauh.projekt.druhy.rocnik;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestApplication {
    public static void main(String[] args) {
        //CreateDatabase();
        //CreateTable();
    }

    public static void CreateDatabase() {
        final String DB_URL = "jdbc:mysql://localhost/";
        final String USER = "root";
        final String PASS = "";

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stat = con.createStatement();
        ) {
            String sql = "Create database test";
            stat.execute(sql);
            JOptionPane.showMessageDialog(null, "Database created succesfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void CreateTable(){
         final String DB_URL = "jdbc:mysql://localhost/test";
         final String USER = "root";
         final String PASS = "";

        try(Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stat = con.createStatement();
        ) {
            String sql = "CREATE TABLE user " +
                    "(id INTEGER not NULL, " +
                    "first_name VARCHAR(255), " +
                    "last_name VARCHAR(255)) ";
            stat.execute(sql);
            JOptionPane.showMessageDialog(null, "Table created succesfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}