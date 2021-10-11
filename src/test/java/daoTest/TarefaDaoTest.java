package daoTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.FuncionarioDao;
import dao.TarefaDao;
import modelo.Funcionario;
import modelo.Tarefa;

@FixMethodOrder(MethodSorters.JVM)
public class TarefaDaoTest {
	TarefaDao tarefaDao = new TarefaDao();
	FuncionarioDao funDao = new FuncionarioDao();
	
/*
	@Test
	public void salvar() {
		Funcionario fun = funDao.buscarId(1);
		Tarefa tarefa2 = new Tarefa("limas", "sala1","media",fun);
		
		tarefaDao.salvar(tarefa2);
		
	}

	@Test
	public void busca() {

		Tarefa t1 = tarefaDao.buscarId(1);
		Tarefa t2 = tarefaDao.buscarId(2);

		System.out.println(t1);
		System.out.println(t2);
	}
	
	@Test
	public void deletar() {
		Tarefa t1 =tarefaDao.buscarId(1);
		tarefaDao.deletar(t1);
	}


	@Test
	public void listar() {

		List<Tarefa> tarefas = tarefaDao.listarTarefas();

		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
	
	}
	*/
	
	@Test
	public void buscaGeral() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaDao.buscaConcluida("concluida",true);
		
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
	}
	
	

}
