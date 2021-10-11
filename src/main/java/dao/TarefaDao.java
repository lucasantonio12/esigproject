package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.ITarefaDao;
import modelo.Tarefa;
import util.HibernateUtil;

public class TarefaDao extends GenericDaoImpl<Tarefa, Integer> implements ITarefaDao {

	public TarefaDao() {
		super(Tarefa.class);

	}

	@SuppressWarnings("unchecked")

	public List<Tarefa> listarTarefas() {
		String sql = "select t from Tarefa t order by titulo";
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery(sql);
		List<Tarefa> tarefas = consulta.getResultList();
		sessao.close();
		return tarefas;

	}

	@SuppressWarnings("unchecked")
	public List<Tarefa> buscaGeral(String campo,String valor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("Select t from"
				+ " Tarefa t where t."+ campo +"= :valor" );
		List<Tarefa> tarefas = consulta.setParameter("valor", valor).getResultList();
		sessao.close();
		return tarefas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> buscaConcluida(String campo,Boolean concluida) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("Select t from"
				+ " Tarefa t where t.concluida="+campo);
		List tarefas = consulta.getResultList();
		sessao.close();
		return tarefas;
	}
	
}
