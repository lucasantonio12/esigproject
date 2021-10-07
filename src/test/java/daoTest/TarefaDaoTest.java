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
	List<Funcionario> listaFun = new ArrayList<Funcionario>();

	@Test
	public void salvar() {

		Tarefa tarefa1 = new Tarefa("limpar", "limpar sala2", Arrays.asList(new Funcionario(1,"adriano", "asg", "casado", "clt")));
		
		tarefaDao.salvar(tarefa1);
		
	}
/*
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
	public void editar() {
		Tarefa tarefas =tarefaDao.buscarId(2);
		tarefas.setDescricao("A tarefa foi concluida.");
		tarefaDao.editar(tarefas);
	}

	@Test
	public void listar() {

		List<Tarefa> tarefas = tarefaDao.listarTarefas();

		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
	}
	*/

}
