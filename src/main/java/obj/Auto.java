package obj;

import javax.persistence.*;

@Entity
@Table(name="auto")
public class Auto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "model")
  private String model;

  @Column(name = "color")
  private String color;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  public Auto() {

  }

  public Auto(String model, String color) {
    this.model = model;
    this.color = color;
  }

  public int getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  public User getUser() {
    return user;
  }

  public void setModel(String value) {
    model = value;
  }

  public void setColor(String value) {
    color = value;
  }

  public void setUser(User value) {
    user = value;
  }

  @Override
  public String toString() {
    return String.format("Auto: ID=%d| model: %s| color: %s|USER_ID: %d|", id, model, color, user.getId());
  }
}
