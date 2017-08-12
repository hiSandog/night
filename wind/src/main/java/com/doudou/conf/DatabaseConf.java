package com.doudou.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by chenjiaming on 2017/8/12.
 */
@Configuration
@MapperScan(basePackages = DatabaseConf.PACKAGE/*, sqlSessionFactoryRef = "sqlSessionFactory"*/)
public class DatabaseConf {

    public static final String PACKAGE = "com.doudou.mybatis.persistence";

   /* @Value("${spring.datasource.zlfh.url}")
    private String dbUrl;
    @Value("${spring.datasource.zlfh.username}")
    private String dbUser;
    @Value("${spring.datasource.zlfh.password}")
    private String dbPassword;
    @Value("${spring.datasource.zlfh.driver-class-name}")
    private String jdbcDriver;*/

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
       return new DruidDataSource();
    }

    /*@Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }*/

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


  /*  @Bean(name = "pageHelper")
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect", "mysql");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource bmsDataSource,
                                               @Qualifier("pageHelper") PageHelper pageHelper) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(bmsDataSource);
        sessionFactory.setPlugins(new Interceptor[] {pageHelper});
       // sessionFactory.setMapperLocations();
        return sessionFactory.getObject();
    }*/

}