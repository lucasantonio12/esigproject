package dao;

import interfaces.IConvidadosDao;
import modelo.Convidados;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class ConvidadoDao extends GenericDaoImpl<Convidados, Integer> implements IConvidadosDao {
    public ConvidadoDao(){
        super(Convidados.class);
    }
    public List<Convidados> listarConvidados() {
        String jpql = "select f from Convidados f order by nome";
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query consulta = sessao.createQuery(jpql);
        List<Convidados> convidados = consulta.getResultList();
        sessao.close();
        return convidados;
    }
}
