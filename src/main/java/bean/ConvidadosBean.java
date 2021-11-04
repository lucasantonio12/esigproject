package bean;

import dao.ConvidadoDao;
import dao.PresentesDao;
import lombok.Data;
import modelo.Convidados;
import modelo.Presentes;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "Convidado", eager = true)
@Named
@ViewScoped
@Data
public class ConvidadosBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Convidados convidados;
    private ConvidadoDao convidadoDao;
    private PresentesDao presentesDao;
    private Presentes presentes;
    private List<Convidados> listaConvidados;
    private List<Presentes> listaPresentes;

    @PostConstruct
    public void iniciar() {
        convidados = new Convidados();
        presentes = new Presentes();
        convidadoDao = new ConvidadoDao();
        presentesDao = new PresentesDao();
        listaPresentes = presentesDao.listarPresentes();
        atualizarTela();
    }

    private void atualizarTela(){
        convidados = new Convidados();
        listaPresentes.clear();
        presentes = new Presentes();
        List<Presentes> aux = presentesDao.listarPresentes();
        for (Presentes presentes: aux){
            if(presentes.getQuantidade() > 0){
                listaPresentes.add(presentes);
            }
        }

    }

    public void salvar(){
        presentes = convidados.getPresentes();
        presentes.setQuantidade(presentes.getQuantidade()-1);
        presentesDao.salvar(presentes);
        convidadoDao.salvar(convidados);
        atualizarTela();
        mensagemInfo("Presença Confirmada");
    }

    public void mensagemInfo(String text) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(text);
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, mensagem);
    }

}
