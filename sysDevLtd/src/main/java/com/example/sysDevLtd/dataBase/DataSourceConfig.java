//package com.example.sysDevLtd.dataBase;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean(name = "mysqlDataSource")
//    @ConditionalOnProperty(name = "spring.mysql.datasource.url")
//    public DataSource mysqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/sec");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        return dataSource;
//    }
//
//    @Bean(name = "h2DataSource")
//    @ConditionalOnProperty(name = "spring.h2.datasource.url")
//    public DataSource h2DataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:test");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("1234");
//        return dataSource;
//    }
//}
