package org.jboss.weld.se.jpa.test;

import junit.framework.TestCase;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author ondra
 */
public class WeldSeJpaTest extends TestCase {
	private final Logger log = LoggerFactory.getLogger(WeldSeJpaTest.class);

	private FooBarManager fbm;
	

	public WeldSeJpaTest(String testName) {
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


		
		// Weld.
		WeldContainer weld = new Weld().initialize();
		//AppClass app = weld.instance().select(AppClass.class).get();
		this.fbm = weld.instance().select( FooBarManager.class ).get();

	}

	
	/**
	 * 
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}


	/**
	 * 
	 */
	@Test
	public void testHello() {
		this.fbm.doSomeJPA();
	}
}
