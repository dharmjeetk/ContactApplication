package com.evolent.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This is Configuration class for initializing all stuff related to connection
 * with database in system
 * 
 * @author dharmjeet.kumar
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:db.properties" })
public class DbConfig {

	@Value(value = "${connection.driver_class}")
	private String driverName;

	@Value(value = "${connection.url}")
	private String url;

	@Value(value = "${connection.username}")
	private String userName;

	@Value(value = "${connection.password}")
	private String password;

	@Autowired
	private Environment enviroment;

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", enviroment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", enviroment.getProperty("hibernate.format_sql"));

		return properties;
	}

	@Bean("contactApplicationSessionFactory")
	public LocalSessionFactoryBean localSessionFactoryBean(@Autowired DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.evolent.backend.domain");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean("contactApplicationDataSource")
	public DriverManagerDataSource oracleDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean("contactApplicationTranscationManager")
	public HibernateTransactionManager hibernateTransactionManager(
			@Autowired @Qualifier(value = "contactApplicationSessionFactory") SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
}
