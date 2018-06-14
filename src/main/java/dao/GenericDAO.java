package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sérgio Matheus
 */
public class GenericDAO {
		private Session session;
		private Class persistentClass;
		private Transaction transaction;

		public GenericDAO() {
		}

		public GenericDAO(Class persistentClass) {
			this.persistentClass = persistentClass;
		}

		public boolean save(Object obj) {
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				transaction = session.beginTransaction();
				session.save(obj);
				transaction.commit();
				return true;
			} catch (HibernateException e) {
				System.out.println("Save_HibernateDAO: " + e);
				transaction.rollback();
				return false;
			}
		}

		public boolean update(Object obj) {
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				transaction = session.beginTransaction();
				session.update(obj);
				transaction.commit();
				return true;
			} catch (HibernateException e) {
				System.out.println("Update_HibernateDAO: " + e);
				transaction.rollback();
				return false;
			}
		}

		public boolean saveOrUpdate(Object obj) {
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				transaction = session.beginTransaction();
				session.saveOrUpdate(obj);
				transaction.commit();
				return true;
			} catch (HibernateException e) {
				System.out.println("Update_HibernateDAO: " + e);
				transaction.rollback();
				return false;
			}
		}

		public boolean delete(Object obj) {
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				transaction = session.beginTransaction();
				session.delete(obj);
				transaction.commit();
				return true;
			} catch (HibernateException e) {
				System.out.println("Delete_HibernateDAO: " + e);
				transaction.rollback();
				return false;
			}
		}

		public Object findByIdPk(Serializable idPk) {
			Object returnObject = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				returnObject = session.get(persistentClass, idPk);
			} catch (HibernateException e) {
				System.out.println("FindById_HibernateDAO: " + e);
			} finally {
				return returnObject;
			}
		}

		public List findAll() {
			List<Object> resultList = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				resultList = session.createCriteria(persistentClass).list();
			} catch (HibernateException e) {
				System.out.println("Hibernate Exception: " + e);
			} finally {
				return resultList;
			}
		}
	}