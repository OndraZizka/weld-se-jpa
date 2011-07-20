package org.jboss.weld.environment.se.jpa;

import javax.persistence.EntityManager;


/**
 * @author Sebastian Hennebrueder
 */
public interface EntityManagerStore {
	/**
	 * Looks for the current entity manager and returns it. If no entity manager
	 * was found, this method logs a warn message and returns null. This will cause a NullPointerException in most
	 * cases and will cause a stack trace starting from your service method.
	 *
	 * @return the currently used entity manager or {@code null} if none was found
	 */
	EntityManager get();

	/**
	 * Creates an entity manager and stores it in a stack. The use of a stack allows to implement
	 * transaction with a 'requires new' behaviour.
	 *
	 * @return the created entity manager
	 */
	EntityManager createAndRegister();

	/**
	 * Removes an entity manager from the thread local stack. It needs to be created using the
	 * {@link #createAndRegister()} method.
	 *
	 * @param entityManager - the entity manager to remove
	 * @throws IllegalStateException in case the entity manager was not found on the stack
	 */
	void unregister(EntityManager entityManager);
	
}// class
