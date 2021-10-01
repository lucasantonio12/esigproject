package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("esigPu");
	
	public static EntityManager getEntityManager(){
		
		EntityManager sessao = fabrica.createEntityManager();
			
		return sessao;	
	}
}
