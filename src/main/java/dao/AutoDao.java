package dao;

import obj.Auto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

class AutoDao<T extends Auto> implements Dao<T> {
  public T findById(int id) {
    try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      return (T) session.get(Auto.class, id);
    }
  }

  @Override
  public List<T> findAll() {
    try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      return (List<T>) session.createQuery("from Auto").list();
    }
  }

  public void save(Auto auto) {
    try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      Transaction trn = session.beginTransaction();
      session.save(auto);
      trn.commit();
    }
  }

  public void update(Auto auto) {
    try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      Transaction trn = session.beginTransaction();
      session.update(auto);
      trn.commit();
    }
  }

  public void delete(Auto auto) {
    try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      Transaction trn = session.beginTransaction();
      session.delete(auto);
      trn.commit();
    }
  }
}
