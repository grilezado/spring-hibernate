package jp.co.springhib.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Env {
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.user}")
	private String user;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${hibernate.packagesToScan}")
	private String packagesToScan;
	
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2dllAuto;

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the packagesToScan
	 */
	public String getPackagesToScan() {
		return packagesToScan;
	}

	/**
	 * @param packagesToScan the packagesToScan to set
	 */
	public void setPackagesToScan(String packagesToScan) {
		this.packagesToScan = packagesToScan;
	}

	/**
	 * @return the hibernateDialect
	 */
	public String getHibernateDialect() {
		return hibernateDialect;
	}

	/**
	 * @param hibernateDialect the hibernateDialect to set
	 */
	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	/**
	 * @return the showSql
	 */
	public String getShowSql() {
		return showSql;
	}

	/**
	 * @param showSql the showSql to set
	 */
	public void setShowSql(String showSql) {
		this.showSql = showSql;
	}

	/**
	 * @return the hbm2dllAuto
	 */
	public String getHbm2dllAuto() {
		return hbm2dllAuto;
	}

	/**
	 * @param hbm2dllAuto the hbm2dllAuto to set
	 */
	public void setHbm2dllAuto(String hbm2dllAuto) {
		this.hbm2dllAuto = hbm2dllAuto;
	}
	
	

}
