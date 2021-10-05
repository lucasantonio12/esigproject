package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "Funcionario",eager = true)
@RequestScoped
public class FuncionarioBean {
	
	public void salvar() {
		System.out.println("botao salvar foi pressionado");
	}
}
