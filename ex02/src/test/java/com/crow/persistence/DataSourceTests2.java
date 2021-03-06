package com.crow.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests2 {
    
    @Setter(onMethod_ = {@Autowired})
    private DataSource dataSource;
    
    @Setter(onMethod_ = {@Autowired})
    private SqlSessionFactory sessionFactory;
    
    @Test
    public void test2() {
    
        try(SqlSession session = sessionFactory.openSession();
                Connection connection = dataSource.getConnection();) {
            
            log.info(session);
            log.info(connection);
        } catch (Exception e) {
            // TODO: handle exception
           fail(e.getMessage());
        }
    }
    
}
