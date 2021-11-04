package daoTest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import bean.FuncionarioBean;
import dao.FuncionarioDao;
import modelo.Funcionario;

@FixMethodOrder(MethodSorters.JVM)
public class FuncionarioDaoTest {
	
	FuncionarioDao funDao = new FuncionarioDao();

	
	

	@Test
	public void salvar() {
		
		Funcionario fun = new Funcionario(null, "Ingrid Rodrigues", "Java" , "Casada", "CLT", "ign", "ingrid123", true);
		Funcionario fun2 = new Funcionario(null, "George LALA", "Tecnologia" , "Divorsiado", "Estagio", "gim", "lucas1213", false);
		Funcionario fun3 = new Funcionario(null, "Ayrton Barreto", "React" , "Solteiro", "CLT", "ayrtim", "@1234", false);
		Funcionario fun4 = new Funcionario(null, "Willian Junior", "Angular" , "Viuvo", "Contrato", "dales", "456", false);
		Funcionario fun5 = new Funcionario(null, "Patric Mateus", "Java" , "Solteiro", "Estagio", "tamara1234", "123", false);
		Funcionario fun6 = new Funcionario(null, "Jhons Dale", "Java" , "Solteiro", "CLT", "dales", "321", false);
		
		funDao.salvar(fun);
		
		
		
	}
		
/*
	@Test
	public void busca() {
		
		Funcionario f1 = funDao.buscarId(2);
		Funcionario f2 = funDao.buscarId(1);
		
		System.out.println(f1);
		System.out.println(f2);
	}
	
	@Test
	public void deletar() {
		Funcionario f1 = funDao.buscarId(2);
		funDao.deleteAssociacao(f1);		
	}
	
	/*
	@Test
	public void listar() {
	
		List<Funcionario> fun = funDao.listarFuncionarios();
		
		for(Funcionario funcionario : fun) {
			System.out.println(funcionario);
		}
	}
	*/
	@Test
	public void logar() {
		Funcionario fun = new Funcionario();
		Funcionario fun2 = new Funcionario();
		fun.setLogin("ign");
		fun2 = funDao.findBy("login", fun.getLogin());
		
		System.out.println(fun2);	
	}
}
