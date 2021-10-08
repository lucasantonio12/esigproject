package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.jboss.logging.Messages;
import org.postgresql.translation.messages_pt_BR;

import dao.FuncionarioDao;
import lombok.Data;
import modelo.Funcionario;
import modelo.Tarefa;

@ManagedBean(name = "Funcionario", eager = true)
@Named
@ViewScoped
@Data
public class FuncionarioBean {

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
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage("Funcionario Salvo");
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage(null, mensagem);
	}
	
	
	public void deletar(Funcionario funcionario) {	
		funcionarioDao.deletar(funcionario);	
		atualizarTela();
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage("Funcionario Deletado");
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage(null, mensagem);
	}
	
	public void editar(Funcionario funcionario) {
		 this.funcionario = funcionario;
	}
	
}
