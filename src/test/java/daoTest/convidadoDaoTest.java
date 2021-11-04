package daoTest;

import dao.ConvidadoDao;
import dao.PresentesDao;
import modelo.Convidados;
import modelo.Presentes;
import org.junit.Test;

public class convidadoDaoTest {

    @Test
    public void salvarConvidado(){
        ConvidadoDao dao = new ConvidadoDao();
        PresentesDao dao2 = new PresentesDao();
        Convidados con = new Convidados(null,"Raul","AFA", dao2.buscarId(2));
        dao.salvar(con);
        System.out.println(dao.listarConvidados());
    }
}
