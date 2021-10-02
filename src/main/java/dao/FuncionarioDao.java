package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import domain.Funcionario;
import util.JpaUtil;

public class FuncionarioDao {
	
	private EntityManager sessao;
	private EntityTransaction trasacao;
	
	public void save(Funcionario funcionario) {
		sessao = JpaUtil.getEntityManager();
		trasacao = sessao.getTransaction();
		trasacao.begin();
		
		sessao.persist(funcionario);
		sessao.close();
		
	}
	
}
