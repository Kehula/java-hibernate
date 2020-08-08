package services;

import dao.AutoDao;
import dao.UserDao;
import obj.Auto;
import obj.User;

import java.util.List;

public class UserService {
  private UserDao userDao = new UserDao();
  private AutoDao autoDao = new AutoDao();

  public UserService() {

  }

  public User findUser(int id) {
    return userDao.findById(id);
  }

  public void saveUser(User user) {
    userDao.save(user);
  }

  public void updateUser(User user) {
    if (user != null)
      userDao.update(user);
  }

  public void deleteUser(User user) {
    if (user != null)
      userDao.delete(user);
  }

  public List<User> findAllUsers() {
    return userDao.findAll();
  }

  public Auto findAuto(int id) {
    return autoDao.findById(id);
  }
}
