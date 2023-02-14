package com.cuprumz.db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCApp {

    @Test
    public void getConn() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test"
                    , "root"
                    , "root");

            PreparedStatement ps = conn.prepareStatement("select @@version");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception ignore) {

        }
    }
}
