package dao;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.IFuncionarioDao;
import modelo.Funcionario;
import util.HibernateUtil;

public class FuncionarioDao extends GenericDaoImpl<Funcionario, Integer> implements IFuncionarioDao {

	public FuncionarioDao() {
		super(Funcionario.class);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarFuncionarios() {
		String jpql = "select f from Funcionario f order by nome";
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery(jpql);
		List<Funcionario> funcionario = consulta.getResultList();
		sessao.close();
		return funcionario;
	}

	public void deleteAssociacao(Funcionario funcionario) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();

		sessao.createNativeQuery("DELETE FROM tarefa_funcionarios WHERE funcionarios_id = ?")
				.setParameter(1, funcionario.getId())
				.executeUpdate();
	
		t.commit();
		t = sessao.beginTransaction();
		sessao.delete(funcionario);
		t.commit();
		
		sessao.close();
	}

}
