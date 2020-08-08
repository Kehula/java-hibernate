package dao;

import java.util.List;

public interface Dao<T> {
  public T findById(int id);

  public void save(T obj);

  public void update(T obj);

  public void delete(T obj);

  public List<T> findAll();
}
