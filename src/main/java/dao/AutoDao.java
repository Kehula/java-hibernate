package dao;

import obj.Auto;
import obj.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

public class AutoDao {
  public Auto findById(int id) {
    try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      return session.get(Auto.class, id);
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
