package com.cuprumz.mybatis;

import com.cuprumz.dao.HeroMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;

public class App {
    
    @Test
    public void gettingStarted() throws Exception {
        String resource = "example/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);

        Properties prop = new Properties();
        prop.load(App.class.getResourceAsStream("/example/datasource.properties"));
        
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is, prop);

        SqlSession session = factory.openSession();

        HeroMapper mapper = session.getMapper(HeroMapper.class);
        
        mapper.findAll().forEach((hero -> {
            System.out.println(hero);
        }));
    }
}
