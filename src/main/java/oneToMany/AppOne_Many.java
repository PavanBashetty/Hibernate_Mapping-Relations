package oneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppOne_Many {

	public static void main(String[] args) {
		
		Employee shel = new Employee("Sheldon");
		Employee leo = new Employee("Leonard");
		Employee raj = new Employee("Raj");
		
		List<Employee> physics_employees = new ArrayList<>();
		physics_employees.add(shel);
		physics_employees.add(leo);
		physics_employees.add(raj);
		
		Department physicsTeam = new Department("Physics", physics_employees);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.persist(physicsTeam);
		
		session.getTransaction().commit();
		session.close();

	}

}
