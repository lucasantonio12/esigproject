package utilTest;

import javax.persistence.EntityManager;

import org.junit.Test;

import domain.Funcionario;
import util.JpaUtil;

public class JpaUtilTest {
	
	@Test
	public void getEntityManegerTest() {
		EntityManager sessao = JpaUtil.getEntityManager();
		
		sessao.close();
	}
}
