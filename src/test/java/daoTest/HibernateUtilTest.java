package daoTest;

import org.hibernate.Session;
import org.junit.Test;

import dao.HibernateUtil;
import model.*;

public class HibernateUtilTest {
    @Test
    public void conectar() {
    	Professor prof= new Professor();
    	prof.setNome_professor("Fernando");
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        sessao.save(prof.getNome_professor());
        sessao.close();
        HibernateUtil.getSessionFactory().close();
    }
}