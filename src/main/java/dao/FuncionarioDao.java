package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Funcionario;
import domain.Tarefa;
import util.JpaUtil;

public class FuncionarioDao {
	
	private EntityManager sessao;
	private EntityTransaction transacao;
	
	public void save(Funcionario funcionario) {
		sessao = JpaUtil.getEntityManager();
		transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(funcionario);
		transacao.commit();
		sessao.close();
		
	}
	
	public Funcionario buscar(Integer numero) {
		sessao = JpaUtil.getEntityManager();
		Funcionario funcionario = sessao.find(Funcionario.class, numero);
		return funcionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario>  listar() {
		String jpql = "select t from Funcionairo t order by titulo";
		sessao = JpaUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Funcionario> funcionario = consulta.getResultList();
		return funcionario;
		
	}
	
	
	
}
