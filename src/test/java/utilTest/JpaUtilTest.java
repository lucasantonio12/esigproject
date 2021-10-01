package utilTest;

import javax.persistence.EntityManager;

import org.junit.Test;

import util.JpaUtil;

public class JpaUtilTest {
	
	@Test
	public void getEntityManegerTest() {
		EntityManager sessão = JpaUtil.getEntityManager();
	}
}
