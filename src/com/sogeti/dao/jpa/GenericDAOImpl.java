package com.sogeti.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.sogeti.entities.TeamDetails;

public abstract class GenericDAOImpl <T, ID extends Serializable> implements GenericDAO<T, ID> {
	
	private Class<T> persistentClass;
	
	private EntityManager entityManager;
	
	public GenericDAOImpl (Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		
		
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	public T findById(ID id) {
		T entity = (T) getEntityManager().find(getPersistentClass(), id);
		return entity;
	}
	
	public List<T> findAll() {
		return getEntityManager().createQuery("select x from "+getPersistentClass()
			.getSimpleName()+" x").getResultList();
		
	}
	
	public T save(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}
	
	public T update(T entity) {
		T mergedEntity = getEntityManager().merge(entity);
		return mergedEntity;
	}
	
	public void delete(T entity) {
		/*if (BaseEntity.class.isAssignableFrom(persistentClass)) {
			getEntityManager().remove(getEntityManager().getReference(entity.getClass(), ((BaseEntity)entity).getId()));
		} else {
			entity = getEntityManager().merge(entity);
			getEntityManager().remove(entity);
		}*/
	}
	
	public void flush() {
		getEntityManager().flush();
	}
}
