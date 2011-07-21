package org.jboss.weld.se.jpa.test;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.environment.se.jpa.JpaTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ondrej Zizka
 */
@Singleton
public class AppClass
{
	private static final Logger log = LoggerFactory.getLogger( AppClass.class );
	
	
	//@Inject	private EntityManager em;

	/**
	 * Instantiates JawaBotApp through CDI/Weld and calls it's run().
	 */
	public static void main(String[] args) {
		WeldContainer weld = new Weld().initialize();
		AppClass app = weld.instance().select(AppClass.class).get();
		app.run(args);
	}

	/**
	 * Run.
	 */
	public void run(String[] args) {
		log.debug(AppClass.class.getSimpleName() + "#run() start.");

		

		log.debug(AppClass.class.getSimpleName() + "#run() end.");
	}
	
	@JpaTransactional
	public void doSomeJPA(){
		//em.persist( new FooBarEntity(12345L, "Those who cannot remember the past are condemned to repeat it."));
	}
	
	
}// class

