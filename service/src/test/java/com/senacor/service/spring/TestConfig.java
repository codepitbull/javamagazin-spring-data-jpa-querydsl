package com.senacor.service.spring;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Jochen Mader
 */
@Configuration
@ComponentScan("com.senacor")
@EnableTransactionManagement
@EnableSpringConfigured
@EnableJpaRepositories("com.senacor")
public class TestConfig {

    @Autowired
    Environment env;

    @Bean(destroyMethod = "close")
    public ComboPooledDataSource comboPooledDataSource() throws SQLException, PropertyVetoException {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setUser("sa");
        source.setPassword("");
        source.setDriverClass("org.h2.Driver");
        source.setJdbcUrl("jdbc:h2:mem:test");
        source.setInitialPoolSize(2);
        source.setMaxPoolSize(10);
        source.setMinPoolSize(2);
        source.setAcquireIncrement(1);
        source.setAcquireRetryAttempts(0);
        return source;
    }

    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException, PropertyVetoException{
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(comboPooledDataSource());
        emf.setJpaVendorAdapter(jpaVendorAdapter());
        emf.setPersistenceUnitName("rss");
        emf.setPackagesToScan("com.senacor.domain");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
//        properties.put("hibernate.show_sql","true");
//        properties.put("hibernate.format_sql", "true");
        emf.setJpaProperties(properties);
        return  emf;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws PropertyVetoException, SQLException{
        JpaTransactionManager trans = new JpaTransactionManager();
        trans.setEntityManagerFactory(entityManagerFactory().getObject());
        return trans;
    }

}
