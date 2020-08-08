package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        Configuration conf = new Configuration().configure();
        //conf.addAnnotatedClass(Auto.class);
        //conf.addAnnotatedClass(User.class);
        //conf.addAnnotatedClass(Employee.class);
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(conf.getProperties());
        registryBuilder.configure();
        sessionFactory = conf.buildSessionFactory(registryBuilder.build());

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sessionFactory;
  }
}
