package daoTest;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.TarefaDao;
import domain.Tarefa;

@FixMethodOrder(MethodSorters.JVM)
public class TarefaDaoTest {
	

	TarefaDao tarefaDao = new TarefaDao();
	

	@Test
	public void salvar() {
		
		Tarefa tarefa = new Tarefa();
		
		
		tarefa.setTitulo("programar front end");
		tarefa.setDescricao("desig do site.");
		
		Tarefa tarefa2 = new Tarefa("limpar","limpesa da sala2");
		Tarefa tarefa3= new Tarefa("manutenção dos pcs ","manutenção na sala de programação");
		
		tarefaDao = new TarefaDao();
		tarefaDao.salvar(tarefa);
		tarefaDao.salvar(tarefa2);
		tarefaDao.salvar(tarefa3);
		
		
	}

	@Test
	public void busca() {
		
	
		Tarefa t1 = tarefaDao.buscas(4);
		Tarefa t2 = tarefaDao.buscas(5);
		
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
