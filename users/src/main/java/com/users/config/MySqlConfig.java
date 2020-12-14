package com.users.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.sogesac.core.entities.Grade;
import javax.sql.DataSource;
import com.google.common.base.Preconditions;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:application.properties"})
@ComponentScan("com.users")

public class MySqlConfig {

  @Autowired
  private Environment env;

  @Bean
  public DataSource getDataSources() {

    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("spring.datasource.url")));
    dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("spring.datasource.username")));
    dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("spring.datasource.password")));

    return dataSource;

  }

  @Bean
  public LocalSessionFactoryBean getSessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(getDataSources());
    sessionFactory.setPackagesToScan(new String[]{"com.users.entities"});
    return sessionFactory;
  }

  @Bean
  public HibernateTransactionManager getTransactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(getSessionFactory().getObject());
    return transactionManager;
  }

}
