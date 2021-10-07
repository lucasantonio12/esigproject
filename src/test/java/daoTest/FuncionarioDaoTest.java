package daoTest;

import java.util.List;

import javax.persistence.criteria.Order;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.FuncionarioDao;
import dao.TarefaDao;
import modelo.Funcionario;
import modelo.Tarefa;

@FixMethodOrder(MethodSorters.JVM)
public class FuncionarioDaoTest {
	
	FuncionarioDao funDao = new FuncionarioDao();
	Funcionario fun = new Funcionario(10,"Lucas", "programador", "namorando", "clt");
	
	
	@Test
	public void salvar() {
		
	
		
		Funcionario fun2 = new Funcionario("adriano", "asg", "casado", "clt");
		Funcionario fun3 = new Funcionario("paula", "front-end programer", "solteira", "clt");
		
	
		//funDao.salvar(fun);
		funDao.salvar(fun2);
		funDao.salvar(fun3);	
		
	}

	@Test
	public void busca() {
		
		Funcionario f1 = funDao.buscarId(2);
		Funcionario f2 = funDao.buscarId(1);
		
		System.out.println(f1);
		System.out.println(f2);
	}
	
	@Test
	public void deletar() {
		Funcionario f1 = funDao.buscarId(1);
		funDao.deletar(f1);		
	}
	
	@Test
	public void editar(){
		Funcionario funcionario = funDao.buscarId(2);
		funcionario.setNome("Paolo Rodrigues");
		funDao.editar(funcionario);
	}
	
	@Test
	public void listar() {
	
		List<Funcionario> fun = funDao.listarFuncionarios();
		
		for(Funcionario funcionario : fun) {
			System.out.println(funcionario);
		}
	}
}
