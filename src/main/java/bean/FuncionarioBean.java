package bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import dao.FuncionarioDao;
import lombok.Data;
import modelo.Funcionario;
import modelo.Tarefa;

@ManagedBean(name = "Funcionario", eager = true)
@Named
@ApplicationScoped
@Data
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	private FuncionarioDao funcionarioDao;
	private List<Funcionario> listaFuncionarios;
	private Tarefa tarefa;

	@PostConstruct
	public void iniciar() {
		funcionarioDao = new FuncionarioDao();
		tarefa = new Tarefa();
		listaFuncionarios = new ArrayList<Funcionario>();
		atualizarTela();
	}

	public void atualizarTela() {
		funcionario = new Funcionario();
		listaFuncionarios = funcionarioDao.listarFuncionarios();
	}

	public void salvar() {

		funcionarioDao.salvar(funcionario);
		atualizarTela();
		mensagemInfo("Funcionario Salvo");
	}

	public void deletar(Funcionario funcionario) {
		funcionarioDao.deleteAssociacao(funcionario);
		atualizarTela();
		mensagemInfo("Funcionario Deletado");
	}

	public void editar(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String senhaProtegida(String senha) {
		String retorno = "";
		MessageDigest md;

		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
			retorno = hash.toString(16);
		} catch (Exception e) {
			mensagemErro("ERRO");
		}

		return retorno;
	}

	public String logar(Funcionario funcionario) {
		System.out.println("TO CLICANDOOOOOOOOOOOOOOOOOOOOOOOO");
		Funcionario fun = new Funcionario();
		fun = funcionarioDao.findBy("logado", funcionario.getLogin());
		if (fun.getLogin() == funcionario.getLogin()) {
			 if (fun.getSenha() == funcionario.getSenha()) 
				return "/funcionario";
			 else 
				mensagemErro("Senha Incorreta");
			
		} else 
			mensagemErro("Login Incorreto");
		
		
		return "";

	}

	public void mensagemInfo(String text) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(text);
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage(null, mensagem);
	}

	public void mensagemErro(String text) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(text);
		mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
	}

}
