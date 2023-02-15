package com.cuprumz.db;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.*;

//@SpringBootTest
public class ConnTest {
    
    @Test
    public void getVersion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
                    , "root"
                    ,"root"
            );
            
            String sql = "select @@version";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
            
        } catch (Exception ignore) {
            
        }
       
    }
    
    
}
