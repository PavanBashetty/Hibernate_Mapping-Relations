package manyToMany_Bi;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

        Student_Bi student1 = new Student_Bi("Pavan", null);
        Student_Bi student2 = new Student_Bi("Goku", null);
        
        List<Student_Bi> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        
        Course_Bi course = new Course_Bi("Java Programming", null);
        course.setStudents(students);
        
        student1.setCourses(List.of(course));
        student2.setCourses(List.of(course));
        
		Configuration config = new Configuration().configure().addAnnotatedClass(Student_Bi.class).addAnnotatedClass(Course_Bi.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.persist(course);
		
		session.getTransaction().commit();
		session.close();
	}

}
