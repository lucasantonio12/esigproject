package bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.FuncionarioDao;
import domain.Funcionario;
import lombok.Data;

@ManagedBean(name = "Funcionario",eager = true)
@Named
@ViewScoped
@Data
public class FuncionarioBean {
	
	private Funcionario funcionario;
	private FuncionarioDao funcionarioDao;
	
	@PostConstruct
	public void iniciar() {
		funcionarioDao = new FuncionarioDao();
		funcionario = new Funcionario();
		
	}
	public void limpar() {
		funcionario = new Funcionario();
	}
	public void salvar() {

		
        FacesContext context = FacesContext.getCurrentInstance();
        
        
        funcionarioDao.salvar(funcionario);
        limpar();
        
        
        FacesMessage mensagem = new FacesMessage("Funcionario Salvo");
        mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(null, mensagem);
	}
}
