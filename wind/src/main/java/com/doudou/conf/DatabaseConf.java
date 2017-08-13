package com.doudou.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by chenjiaming on 2017/8/12.
 */
@Configuration
@MapperScan(basePackages = DatabaseConf.PACKAGE)
public class DatabaseConf {

    public static final String PACKAGE = "com.doudou.mybatis.persistence";

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
       return new DruidDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}