package dao;

import obj.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

class UserDao<T extends User> implements Dao<T>{
  public T findById(int id) {
    try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      return (T)session.get(User.class, id);
    }
  }

  public void save(User user) {
    try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      Transaction trn = session.beginTransaction();
      session.save(user);
      trn.commit();
    }
  }

  public void update(User user) {
    try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      Transaction trn = session.beginTransaction();
      session.update(user);
      trn.commit();
    }
  }

  public void delete(User user) {
    try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      Transaction trn = session.beginTransaction();
      session.delete(user);
      trn.commit();
    }
  }

  public List<T> findAll() {
    try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      return (List<T>) session.createQuery("from User").list();
    }
  }
}
