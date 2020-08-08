package obj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends User {

  @Column(name = "salary")
  private float salary;

  public Employee() {
    super();
  }

  public Employee(String name, int age) {
    super(name,age);
  }


  public float getSalary() {
    return salary;
  }

  public void setSalary(float value) {
    salary = value;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Employee) {
      Employee employee = (Employee) obj;
      return this.getId() == employee.getId() && this.getName().equals(employee.getName()) &&
          this.getAge() == employee.getAge() && this.salary == employee.getSalary();
    }
    return false;
  }

  @Override
  public String toString() {
    return super.toString() + String.format("salary %.2f|", salary);
  }
}
