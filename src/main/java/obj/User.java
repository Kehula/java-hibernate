package obj;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name="name")
  private String name;

  @Column(name="age")
  private int age;

  @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Auto> autos;

  public User() {

  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
    autos = new ArrayList<>();
  }

  public void addAuto(Auto auto) {
    if (auto != null) {
      auto.setUser(this);
      autos.add(auto);
    }
  }

  public void removeAuto(Auto auto) {
    autos.remove(auto);
  }

  public int getId() {
    return id;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public void setName(String value) {
    name = value;
  }

  public void setAge(int value) {
    age = value;
  }

  @Override
  public String toString() {
    return String.format("id: %d|User: %s|Age: %d|",id, name, age);
  }
}
