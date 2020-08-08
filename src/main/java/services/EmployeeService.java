package services;

import dao.Dao;
import dao.DaoFactory;
import obj.Employee;

import java.util.List;

public class EmployeeService extends UserService {

  Dao employeeDao;

  public EmployeeService() {
    employeeDao = DaoFactory.getInstance().getInstance(Employee.class);
  }

  protected Dao getUserDao() {
    return employeeDao;
  }

  public List<Employee> findAllEmployees() {
    return getUserDao().findAll();
  }
}
