package utilTest;


import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class HibenateUtilTest {
	
	@Test
	public void getEntityManegerTest() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		sessao.close();
	}
}
