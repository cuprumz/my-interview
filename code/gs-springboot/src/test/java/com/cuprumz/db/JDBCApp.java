package com.cuprumz.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCApp {

    private final String LocalMySQLUrl = "jdbc:mysql://localhost:3306/test";
    private final String username = "root";
    private final String passwd = "root";
    

    @Test
    public void getConn() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    LocalMySQLUrl
                    , username
                    , passwd);

            PreparedStatement ps = conn.prepareStatement("select @@version");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception ignore) {

        }
    }
    
    
    @Test
    public void pooledConn() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(LocalMySQLUrl);
        config.setUsername(username);
        config.setPassword(passwd);
        DataSource ds = new HikariDataSource(config);

        Connection conn = ds.getConnection();
        
        PreparedStatement ps = conn.prepareStatement("select @@version");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        
        rs.close();
        ps.close();
        conn.close();
    }
}
