import obj.Auto;
import obj.Employee;
import obj.User;
import obj.User_;
import services.EmployeeService;
import services.UserService;
import utils.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kehul on 06.08.2020
 */
public class Main {
	
	public static void main(String[] args) {
		//firstTest();
		secondTest();
	}

	public static void secondTest() {
		UserService userService = new UserService();

		User user1 = new User("Alex", 22);
		userService.saveUser(user1);

		Auto auto = new Auto("Lada", "Black");
		user1.addAuto(auto);
		userService.updateUser(user1);

		User user2 = new User("Alex bizzare", 22);
		userService.saveUser(user2);

		user2.addAuto(auto);
		userService.updateUser(user2);

		List<User> users = userService.findAllUsers();
		users.forEach(System.out::println);

		userService.deleteUser(users.get(0));
		List<User> usersAfterDelete = userService.findAllUsers();

		//users - usersAfterDelete
		System.out.println("Deleted users:");
		users.stream().filter(user -> !usersAfterDelete.contains(user)).collect(Collectors.toList()).
				forEach(System.out::println);

		Employee employee = new Employee("Don", 35);
		employee.setSalary(100000);
		userService.saveUser(employee);

		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = employeeService.findAllEmployees();
		employees.forEach(System.out::println);

		employeeService.deleteUser(employees.get(0));

		List<Employee> employeesAfterDelete = employeeService.findAllEmployees();

		//employees - employeesAfterDelete
		System.out.println("Deleted employees:");
		employees.stream().filter(empl -> !employeesAfterDelete.contains(empl)).collect(Collectors.toList()).
				forEach(System.out::println);

		System.out.println("Queries through CriteriaBuilder & EntityManager");
		EntityManager em = HibernateSessionFactory.getSessionFactory().createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> userRoot = query.from(User.class);
		query.select(userRoot);
		query.where(cb.equal(userRoot.get(User_.age), 35));
		System.out.println("age = 35");
		em.createQuery(query).getResultList().forEach(System.out::println);

		System.out.println("\nid between 20 and 30");
		query.where(cb.between(userRoot.get(User_.id), 20, 30));
		em.createQuery(query).getResultList().forEach(System.out::println);
		em.getTransaction().commit();
		em.close();
	}
}
