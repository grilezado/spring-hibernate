package jp.co.springhib.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class})  
@ComponentScans( value = {@ComponentScan("boot.entry"),
		@ComponentScan("domain"),
		@ComponentScan("controller"),
		@ComponentScan("dao"),
		@ComponentScan("service") 
		}
)
public class Config {
	
	@Autowired
	private Env env;

	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getDriver().trim());
		dataSource.setUrl(env.getUrl().trim());
		dataSource.setUsername(env.getUser().trim());
		dataSource.setPassword(env.getPassword());
		
		return dataSource;		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();  
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(env.getPackagesToScan().trim());
        
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getHibernateDialect().trim());
        properties.setProperty("hibernate.show_sql", env.getShowSql().trim());
        properties.setProperty("hibernate.hbm2ddl.auto", env.getHbm2dllAuto().trim());  
        
        sessionFactory.setHibernateProperties(properties);        
        return sessionFactory;        
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}
	
}
