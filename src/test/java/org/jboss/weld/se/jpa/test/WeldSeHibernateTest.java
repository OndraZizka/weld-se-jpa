package org.jboss.weld.se.jpa.test;

import junit.framework.TestCase;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Ignore;



/**
 *
 * @author ondra
 */
@Ignore
public class WeldSeHibernateTest extends TestCase {
	

	private FooBarManager fbm;
	

	public WeldSeHibernateTest(String testName) {
			super(testName);
	}

	protected void setUp() throws Exception {
		/*
			// "Connect" to the db.
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			// TODO: Problem: HSQLDB reads CSV only from it's dir!
			String dbPath = StringUtils.defaultIfEmpty( this.options.dbPath, "hsqldb") + "/cruncher";
			this.conn = DriverManager.getConnection("jdbc:hsqldb:file:"+dbPath+";shutdown=true", "SA", "");
		*/


		// Hibernate (native).
		Configuration config = new Configuration()
			  .setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
			  .setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbc.JDBCDriver")
			  //.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:baseball")
			  .setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:foobardb")
			  .setProperty("hibernate.connection.username", "sa")
			  .setProperty("hibernate.connection.password", "")
			  .setProperty("hibernate.connection.pool_size", "1")
			  .setProperty("hibernate.connection.autocommit", "true")
			  .setProperty("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider")
			  .setProperty("hibernate.hbm2ddl.auto", "create-drop")
			  .setProperty("hibernate.show_sql", "true")
			  .addClass(FooBarEntity.class)
				;
		SessionFactory buildSessionFactory = config.buildSessionFactory();

		
		// Weld.
		WeldContainer weld = new Weld().initialize();
		//AppClass app = weld.instance().select(AppClass.class).get();
		FooBarManager fbm = weld.instance().select( FooBarManager.class ).get();

	}

	protected void tearDown() throws Exception {
			super.tearDown();
	}


	/**
	 * 
	 */
	@Ignore
	public void testHello() {
		fbm.doSomeJPA();
	}
}
