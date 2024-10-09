package manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App {

	public static void main(String[] args) {
		
        Student student1 = new Student("Pavan");
        Student student2 = new Student("Goku");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        
        Course course = new Course("Java Programming", students);
        
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.persist(course);
		
		session.getTransaction().commit();
		session.close();
	}

}
