package dao;

import obj.Auto;
import obj.Employee;
import obj.User;

public class DaoFactory {
  private static DaoFactory instance;

  public static DaoFactory getInstance() {
    if (instance == null)
      instance = new DaoFactory();
    return instance;
  }

  public Dao getInstance(Class tClass) {
    if (tClass == Employee.class)
      return new EmployeeDao<Employee>();

    if (tClass == User.class)
      return new UserDao<User>();

    if (tClass == Auto.class) {
      return new AutoDao<Auto>();
    }
    return null;
  }
}
