package org.jboss.weld.environment.se.jpa;
//package de.laliluna.transactions;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;
import java.util.Map;

/**
   The fake entity manager is not the real instance of the entity manager but it is a delegate. It will fetch the current entity manager from the EntityManagerStore and will delegate to this entity manager.
   Don’t forget that your IDE can generate delegate methods. Don’t write the code!

 * @author Sebastian Hennebrueder
 */
@ApplicationScoped
public class EntityManagerDelegate implements EntityManager {

	@Inject
	private EntityManagerStore entityManagerStore;

	public void persist(Object entity) {
		entityManagerStore.get().persist(entity);
	}

	public <T> T merge(T entity) {
		return entityManagerStore.get().merge(entity);
	}

	public void remove(Object entity) {
		entityManagerStore.get().remove(entity);
	}

	public <T> T find(Class<T> entityClass, Object primaryKey) {
		return entityManagerStore.get().find(entityClass, primaryKey);
	}

	public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
		return entityManagerStore.get().find(entityClass, primaryKey, properties);
	}

	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
		return entityManagerStore.get().find(entityClass, primaryKey, lockMode);
	}

	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
		return entityManagerStore.get().find(entityClass, primaryKey, lockMode, properties);
	}

	public <T> T getReference(Class<T> entityClass, Object primaryKey) {
		return entityManagerStore.get().getReference(entityClass, primaryKey);
	}

	public void flush() {
		entityManagerStore.get().flush();
	}

	public void setFlushMode(FlushModeType flushMode) {
		entityManagerStore.get().setFlushMode(flushMode);
	}

	public FlushModeType getFlushMode() {
		return entityManagerStore.get().getFlushMode();
	}

	public void lock(Object entity, LockModeType lockMode) {
		entityManagerStore.get().lock(entity, lockMode);
	}

	public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		entityManagerStore.get().lock(entity, lockMode, properties);
	}

	public void refresh(Object entity) {
		entityManagerStore.get().refresh(entity);
	}

	public void refresh(Object entity, Map<String, Object> properties) {
		entityManagerStore.get().refresh(entity, properties);
	}

	public void refresh(Object entity, LockModeType lockMode) {
		entityManagerStore.get().refresh(entity, lockMode);
	}

	public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		entityManagerStore.get().refresh(entity, lockMode, properties);
	}

	public void clear() {
		entityManagerStore.get().clear();
	}

	public void detach(Object entity) {
		entityManagerStore.get().detach(entity);
	}

	public boolean contains(Object entity) {
		return entityManagerStore.get().contains(entity);
	}

	public LockModeType getLockMode(Object entity) {
		return entityManagerStore.get().getLockMode(entity);
	}

	public void setProperty(String propertyName, Object value) {
		entityManagerStore.get().setProperty(propertyName, value);
	}

	public Map<String, Object> getProperties() {
		return entityManagerStore.get().getProperties();
	}

	public Query createQuery(String qlString) {
		return entityManagerStore.get().createQuery(qlString);
	}

	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
		return entityManagerStore.get().createQuery(criteriaQuery);
	}

	public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
		return entityManagerStore.get().createQuery(qlString, resultClass);
	}

	public Query createNamedQuery(String name) {
		return entityManagerStore.get().createNamedQuery(name);
	}

	public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
		return entityManagerStore.get().createNamedQuery(name, resultClass);
	}

	public Query createNativeQuery(String sqlString) {
		return entityManagerStore.get().createNativeQuery(sqlString);
	}

	public Query createNativeQuery(String sqlString, Class resultClass) {
		return entityManagerStore.get().createNativeQuery(sqlString, resultClass);
	}

	public Query createNativeQuery(String sqlString, String resultSetMapping) {
		return entityManagerStore.get().createNativeQuery(sqlString, resultSetMapping);
	}

	public void joinTransaction() {
		entityManagerStore.get().joinTransaction();
	}

	public <T> T unwrap(Class<T> cls) {
		return entityManagerStore.get().unwrap(cls);
	}

	public Object getDelegate() {
		return entityManagerStore.get().getDelegate();
	}

	public void close() {
		entityManagerStore.get().close();
	}

	public boolean isOpen() {
		return entityManagerStore.get().isOpen();
	}

	public EntityTransaction getTransaction() {
		return entityManagerStore.get().getTransaction();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerStore.get().getEntityManagerFactory();
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return entityManagerStore.get().getCriteriaBuilder();
	}

	public Metamodel getMetamodel() {
		return entityManagerStore.get().getMetamodel();
	}
		
}// class

