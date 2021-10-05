package daoTest;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.FuncionarioDao;
import dao.TarefaDao;
import domain.Funcionario;
import domain.Tarefa;

@FixMethodOrder(MethodSorters.JVM)
public class TarefaDaoTest {
	

	TarefaDao tarefaDao = new TarefaDao();
	

	@Test
	public void salvar() {
		
	
		Funcionario fun = new Funcionario(null,"Lucas", "programador", "namorando", "clt");
		Funcionario fun2 = new Funcionario(null,"adriano", "asg", "casado", "clt");
		Funcionario fun3 = new Funcionario(null,"paula", "front-end programer", "solteira", "clt");
		
		FuncionarioDao funDao = new FuncionarioDao();
		funDao.salvar(fun);
		funDao.salvar(fun2);
		funDao.salvar(fun3);
		
		Tarefa tarefa = new Tarefa(null,"programar esig projeto", "fazer projeto", fun);
		Tarefa tarefa2 = new Tarefa(null,"limpar", "limpar sala2", fun2);
		Tarefa tarefa3 = new Tarefa(null,"programar front-end", "fazer o projeto", fun3);
		
		tarefaDao = new TarefaDao();
		tarefaDao.salvar(tarefa);
		tarefaDao.salvar(tarefa2);
		tarefaDao.salvar(tarefa3);
		
		
	}

	@Test
	public void busca() {
		
	
		Tarefa t1 = tarefaDao.buscar(4);
		Tarefa t2 = tarefaDao.buscar(5);
		
		System.out.println(t1);
		System.out.println(t2);
	}
	
	@Test
	public void listar() {
	
		List<Tarefa> tarefas = tarefaDao.listar();
		
		for(Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
	}
	
}
