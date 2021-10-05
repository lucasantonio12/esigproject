package daoTest;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.FuncionarioDao;
import dao.TarefaDao;
import domain.Funcionario;
import domain.Tarefa;

@FixMethodOrder(MethodSorters.JVM)
public class FuncionarioDaoTest {
	
	FuncionarioDao funDao = new FuncionarioDao();
	
	@Test
	public void salvar() {
		
	
		Funcionario fun = new Funcionario(null,"Lucas", "programador", "namorando", "clt");
		Funcionario fun2 = new Funcionario(null,"adriano", "asg", "casado", "clt");
		Funcionario fun3 = new Funcionario(null,"paula", "front-end programer", "solteira", "clt");
		
	
		funDao.salvar(fun);
		funDao.salvar(fun2);
		funDao.salvar(fun3);	
		
	}

	@Test
	public void busca() {
		
		Funcionario f1 = funDao.buscar(2);
		Funcionario f2 = funDao.buscar(1);
		
		System.out.println(f1);
		System.out.println(f2);
	}
	
	@Test
	public void listar() {
	
		List<Funcionario> fun = funDao.listar();
		
		for(Funcionario funcionario : fun) {
			System.out.println(funcionario);
		}
	}
}
