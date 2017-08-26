package com.sogeti.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DAO<T> {

	private Session session;
	private Class class1;
	
	public DAO(Class<T> class1, Session session) {
		this.class1 = class1;
		this.session = session;
		if (!this.session.getTransaction().isActive()) {
			this.session.beginTransaction();
		}
	}
	
	public void save(T o) {
		this.session.save(o);
	}
	
	public T getObjectById(Serializable id) {
		Criteria criteria = this.session.createCriteria(class1);
		criteria.add(Restrictions.eq("id", id));
		return (T) criteria.uniqueResult();
	}
	
	public <T> List<T> getAll() {
	      Criteria crit = this.session.createCriteria(class1);
	      return crit.list();
	}
	
	public void delete(Serializable id) {
		T obj = (T) session.load(class1, id);
		this.session.delete(obj);
	}
	
	/***/
    public <T> T merge(T o)   {
    	System.out.println("Inside DAO merge");
      return (T) session.merge(o);
    }

    /***/
    public <T> T saveOrUpdate(T o){
      session.saveOrUpdate(o);
	return o;
    }
}
