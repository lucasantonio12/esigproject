package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.JpaUtil;

public class TestaConexão {
	
	public static void main(String[] args) {
		
		EntityManager sessao =  JpaUtil.getEntityManager();
		sessao.close();
		
	}

}
