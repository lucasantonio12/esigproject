package dao;

import interfaces.IPresentesDao;
import modelo.Presentes;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class PresentesDao extends GenericDaoImpl<Presentes,Integer> implements IPresentesDao {

    public PresentesDao(){
        super(Presentes.class);
    }
    public List<Presentes> listarPresentes() {
        String jpql = "select f from Presentes f order by nome";
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query consulta = sessao.createQuery(jpql);
        List<Presentes> presentes = consulta.getResultList();
        sessao.close();
        return presentes;
    }
}
