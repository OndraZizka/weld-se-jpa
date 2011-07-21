package org.jboss.weld.se.jpa.test;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.jboss.weld.environment.se.jpa.JpaTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Typical JPA-based manager.
 * Like in Java EE 6, it requests EntityManager to be injected.
 * 
 * @author Ondrej Zizka
 */
@ApplicationScoped
public class FooBarManager
{
	private static final Logger log = LoggerFactory.getLogger( AppClass.class );
	
	
	@Inject	private EntityManager em;
	
	@JpaTransactional
	public void doSomeJPA(){
		FooBarEntity ent = new FooBarEntity( null, "Those who cannot remember the past are condemned to repeat it." );
		em.persist( ent );
		log.info(" Persisted entity - resulting ID: " + ent.getId() );
	}

}// class

