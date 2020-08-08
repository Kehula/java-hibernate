package dao;

import obj.Employee;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.util.List;

class EmployeeDao<T extends Employee> extends UserDao<T> implements Dao<T> {

  public List<T> findAll() {
    try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
      return (List<T>) session.createQuery("from Employee ").list();
    }
  }
}
