package oneToMany_Bi;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App_oneToManyBi {

	public static void main(String[] args) {
		
		Department_Bi fictionTeam = new Department_Bi("HR", null);

        Employee_Bi emp1 = new Employee_Bi("Alice", fictionTeam);
        Employee_Bi emp2 = new Employee_Bi("Bob", fictionTeam);
        Employee_Bi emp3 = new Employee_Bi("Charlie", fictionTeam);

        List<Employee_Bi> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        
        fictionTeam.setEmployees(employees);
        
		Configuration config = new Configuration().configure().addAnnotatedClass(Employee_Bi.class).addAnnotatedClass(Department_Bi.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.persist(fictionTeam);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
