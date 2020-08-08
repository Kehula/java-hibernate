package services;

import dao.Dao;
import dao.DaoFactory;
import obj.Auto;
import obj.User;

import java.util.List;

public class UserService {
  private Dao userDao;
  private Dao autoDao;

  public UserService() {
    userDao = DaoFactory.getInstance().getInstance(User.class);
    autoDao = DaoFactory.getInstance().getInstance(Auto.class);
  }

  protected Dao getUserDao() {
    return userDao;
  }

  protected Dao getAutoDao() {
    return autoDao;
  }

  public User findUser(int id) {
    return (User)getUserDao().findById(id);
  }

  public void saveUser(User user) {
    getUserDao().save(user);
  }

  public void updateUser(User user) {
    if (user != null)
      getUserDao().update(user);
  }

  public void deleteUser(User user) {
    if (user != null)
      getUserDao().delete(user);
  }

  public final List<User> findAllUsers() {
    return getUserDao().findAll();
  }

  public Auto findAuto(int id) {
    return (Auto) getAutoDao().findById(id);
  }
}
