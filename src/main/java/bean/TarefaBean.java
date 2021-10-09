package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.jboss.logging.Messages;
import org.postgresql.translation.messages_pt_BR;

import dao.FuncionarioDao;
import dao.TarefaDao;
import lombok.Data;
import modelo.Funcionario;
import modelo.Tarefa;

@ManagedBean(name = "Tarefa", eager = true)
@Named
@ViewScoped
@Data
public class TarefaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Tarefa tarefa;
	private TarefaDao tarefaDao;
	private List<Tarefa> listaTarefa;

	private FuncionarioDao funDao;
	private List<Funcionario> listaFuncionarios;

	@PostConstruct
	public void iniciar() {
		tarefaDao = new TarefaDao();
		listaTarefa = new ArrayList<Tarefa>();
		funDao = new FuncionarioDao();

		listaFuncionarios = funDao.listarFuncionarios();
		atualizarTela();
	}

	public void atualizarTela() {
		tarefa = new Tarefa();
		listaTarefa.clear();
		
		List<Tarefa> listaAux = tarefaDao.listarTarefas();
		 	
		for (Tarefa tarefa : listaAux) {
			if (tarefa.getConcluida() == false) {
				listaTarefa.add(tarefa);
			}
		}
	}

	public void salvar() {

		tarefaDao.salvar(tarefa);

		atualizarTela();

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage("Tarefa Salvo");
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage(null, mensagem);
	}

	public void deletar(Tarefa tarefa) {
		tarefaDao.deletar(tarefa);
		atualizarTela();

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage("Tarefa Deletado");
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage(null, mensagem);
	}

	public void editar(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public void concluida(Tarefa tarefa) {
		tarefa.setConcluida(true);
		tarefaDao.salvar(tarefa);
		atualizarTela();
	}



}
