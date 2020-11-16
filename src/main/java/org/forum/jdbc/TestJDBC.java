package org.forum.jdbc;

import org.forum.entity.DatabaseOperations;
import org.forum.entity.Uzivatel;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {


        String jdbcUrl = "jdbc:mysql://localhost:9030/hb_database?useSSL=false";
        String user = "root";
        String password = "root";

        try {

            System.out.println("Connecting to database " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("Connection successful!!!");
        }

        catch (Exception exc) {
            exc.printStackTrace();
        }
    }


}
