package com.fcb.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fcb.entity.UserRole;
import com.fcb.entity.Users;
import com.fcb.security.config.FCBSecurityConfig;

@Configuration
@Import(value=FCBSecurityConfig.class)
@ComponentScan(basePackages="com.fcb.service,com.fcb.dao")
public class RootConfig {


	
	//@Bean
	public DataSource createDataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("system");
		dataSource.setPassword("manager");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean createLocalSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(createDataSource());
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		factoryBean.setHibernateProperties(props);
	
		factoryBean.setAnnotatedClasses(Users.class);
		factoryBean.setAnnotatedClasses(UserRole.class);
		
		System.out.println("sessionfactory====== :"+factoryBean);
		return factoryBean;
	}

	
	
}
