//package de.laliluna.transactions;
package org.jboss.weld.environment.se.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
Now, we can create a transaction interceptor. It will start a transaction before a transactional method is called and commit it after the method was executed.
In addition it will register an entity manager in the EntityManagerStore and unregister it afterwards. Finally, it will roll back transactions in case of an exception.

The annotations @Interceptor and @Transactional tell Weld that every time it finds a @Transactional annotation it needs to call the interceptor.

 * 
 * A simple transaction interceptor which registers an entity mangager in a ThreadLocal and unregisters after the
 * method was called.
 * It does not support any kind of context propagation. If a transactional method calls another's bean transactional
 * method a new entity manager is created and added to the stack.
 *
 * @author Sebastian Hennebrueder
 */
@Interceptor
@JpaTransactional
public class JpaTransactionInterceptor {

		@Inject
		private EntityManagerStore entityManagerStore;
		private Logger logger = LoggerFactory.getLogger(JpaTransactionInterceptor.class);

		@AroundInvoke
		public Object runInTransaction(InvocationContext invocationContext) throws Exception {


				// Create / get EM.
				EntityManager em = entityManagerStore.createAndRegister();

				Object result = null;
				try {
						em.getTransaction().begin();
						result = invocationContext.proceed();
						em.getTransaction().commit();
				}
				catch (Exception e) {
						try {
								if (em.getTransaction().isActive()) {
										em.getTransaction().rollback();
										logger.debug("Rolled back transaction");
								}
						}
						catch (Exception e1) {
								logger.warn("Rollback of transaction failed: " + e1);
						}
						throw e;
				}
				finally {
						if (em != null) {
								entityManagerStore.unregister(em);
								em.close();
						}
				}

				return result;
		}
}// class
