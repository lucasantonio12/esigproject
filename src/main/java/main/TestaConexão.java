package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.HibernateUtil;


public class TestaConexão {
	
	public static void main(String[] args) {
		
		EntityManager sessao =  HibernateUtil.getSessionFactory().createEntityManager();
		sessao.close();
		
	}

}
