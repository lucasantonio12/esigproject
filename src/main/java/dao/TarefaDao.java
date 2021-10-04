package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Tarefa;
import util.JpaUtil;

public class TarefaDao {

	private EntityManager sessao;
	private EntityTransaction transacao;

	public void salvar(Tarefa tarefa) {

		sessao = JpaUtil.getEntityManager();
		transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(tarefa);
		transacao.commit();
		sessao.close();
		

	}

	public Tarefa buscar(Integer numero) {
		sessao = JpaUtil.getEntityManager();
		Tarefa tarefa = sessao.find(Tarefa.class, numero);
		return tarefa;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa>  listar() {
		String jpql = "select t from Tarefa t order by titulo";
		sessao = JpaUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Tarefa> tarefas = consulta.getResultList();
		return tarefas;
		
	}
	
	

}
