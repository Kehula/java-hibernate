import obj.Auto;
import obj.Employee;
import obj.HibernateTestData;
import obj.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import services.EmployeeService;
import services.UserService;
import utils.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
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

	public static void firstTest() {
		System.out.println("Direct SQL:");
		System.out.println("\tTesting connection...");
		try {
			//Connection con = DriverManager.getConnection("jdbc:mysql://192.168.2.105:3306/webshop", "sysdba", "masterkey");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop", "sysdba", "masterkey");
			if (!con.isClosed()) {
				System.out.println("\tConnection opened!");

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from test_table");
				while (rs.next()) {
					System.out.println(String.format("\t|%10d|%20s|", rs.getInt(1), rs.getString(2)));
				}
			}
			System.out.println("\tClosing connection\n");
			con.close();

			System.out.println("Hibernate connection:");
			HibernateTestData data = new HibernateTestData();
			data.setName("Hibernate");
			data.setCaption("Hello world!");

			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			SessionFactory sessionFactory;
			try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				StandardServiceRegistryBuilder.destroy(registry);
				throw e;
			}
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(data);

			session.getTransaction().commit();

			session.beginTransaction();
			List<HibernateTestData> dataList = session.createQuery("from HibernateTestData").list();
			dataList.forEach(item -> System.out.println(String.format("\t%10d|%20s|%20s|", item.getId(), item.getName(), item.getCaption())));
			session.getTransaction().commit();
			session.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		query.where(cb.equal(userRoot.get("age"), 35));
		em.createQuery(query).getResultList().forEach(System.out::println);
		em.getTransaction().commit();
		em.close();
	}
}
