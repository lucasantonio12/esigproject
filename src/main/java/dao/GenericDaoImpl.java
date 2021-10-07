package dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
		session.persist((T) object);
		t.commit();
		this.session.close();
	}

	@Override
	public void editar(T object) {
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

}
