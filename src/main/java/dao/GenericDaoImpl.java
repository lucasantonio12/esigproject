package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import interfaces.IGenericDao;
import util.HibernateUtil;

public class GenericDaoImpl<T, ID extends Serializable> implements IGenericDao<T, ID> {

	private Class<T> klass;
	private Session session = null;

	public GenericDaoImpl() {
	}

	public GenericDaoImpl(Class<T> klass) {

		this.klass = klass;
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public T buscarId(ID id) {
		this.session = HibernateUtil.getSessionFactory().openSession();
		T object = (T) session.get(klass, id);
		this.session.close();
		return object;
	}

	@Override
	public void salvar(T object) {
		this.session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.merge((T) object);
		session.flush();
		t.commit();
		this.session.close();
	}

	@Override
	public void deletar(T object) {
		this.session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete((T) object);
		t.commit();
		this.session.close();
	}
	
	 @Override
	    public List<T> findAllBy(String property, List<?> values) {
	        return findAllBy(property, values, null);
	    }

	    @SuppressWarnings("unchecked")
	    @Override
	    public List<T> findAllBy(String property, List<?> values, Order order) {

	        //this.session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();

	        Criteria criteria = session.createCriteria(klass)
	                .add(Restrictions.in(property, values));
	        if (order != null) {
	            criteria.addOrder(order);
	        }
	        transaction.commit();
	        return (List<T>) criteria.list();
	    }

	    @SuppressWarnings("serial")
	    public List<T> findAllBy(String property, final Object value) {
	        return findAllBy(property, new ArrayList<Object>() {
	            {
	                add(value);
	            }
	        }, null);
	    }

	    @SuppressWarnings("serial")
		@Override
	    public List<T> findAllBy(String property, final Object value, Order order) {
	        return findAllBy(property, new ArrayList<Object>() {
	            {
	                add(value);
	            }
	        }, order);
	    }

	    @Override
	    public List<T> findAll() {
	        //this.session = HibernateUtil.getSessionFactory().openSession();
	        return findAll(null);
	       
	    }

	    @Override
	    public List<T> findAll(Order order) {

	        //this.session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        Criteria criteria = session.createCriteria(klass);
	        if (order != null) {
	            criteria.addOrder(order);
	        }
	        transaction.commit();
	        //this.session.close();
	        return (List<T>) criteria.list();
	    }

	    @Override
	    public T findBy(String property, final Object value) {
	        List<T> results = findAllBy(property, value);
	        if (results == null || results.isEmpty()) {
	            return null;
	        }
	        return results.get(0);
	    }

	

}
