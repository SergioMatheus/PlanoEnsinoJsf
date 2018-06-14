package dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.*;

	public class HibernateUtil implements Serializable{
		private static final long serialVersionUID = 1L;

		private static SessionFactory sessionFactory;

		static {
			try {
				sessionFactory = new Configuration().configure()
						.addPackage("model")
						.addAnnotatedClass(Bibliografia.class)
						.addAnnotatedClass(Conteudo.class)
						.addAnnotatedClass(Disciplina.class)
						.addAnnotatedClass(PlanoDeEnsino.class)
						.addAnnotatedClass(Professor.class)
						.addAnnotatedClass(Recurso.class)
						.buildSessionFactory();
			} catch (Throwable ex) {
				ex.printStackTrace();
				throw new ExceptionInInitializerError(ex);
			}
		}

		public static SessionFactory getSessionfactory() {
			return sessionFactory;
		}
		
		 public static SessionFactory getSessionFactory() {
		        if (sessionFactory == null) {
		            try {
		                Configuration ac = new Configuration();
		                sessionFactory = ac.configure().buildSessionFactory();
		            } catch (Throwable ex) {
		                System.err.println("Initial SessionFactory creation failed." + ex);
		                throw new ExceptionInInitializerError(ex);
		            }
		            return sessionFactory;
		        } else {
		            return sessionFactory;
		        }
		    }

	}