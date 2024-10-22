package com.infosupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBasics {

    public static void main(String[] args) throws SQLException {
        // 1
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // 2
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");

        // 3
        Statement statement = connection.createStatement();

        // 4
        ResultSet result = statement.executeQuery("SELECT * FROM Person");

        // 5
        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);

            System.out.println(id + "-" + name);
        }

        connection.close();
    }
}
