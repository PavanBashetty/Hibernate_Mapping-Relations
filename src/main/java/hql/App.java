package hql;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class App {

	public static void main(String[] args) {
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(Pupils.class);
    	SessionFactory sf = config.buildSessionFactory();
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
    	//To get the list of pupils
		Query<Pupils> q = session.createQuery("from Pupils where marks > 50", Pupils.class);
		List<Pupils> pupilList = q.getResultList();
		for(Pupils p: pupilList) {
			System.out.println(p);
		}
		
		System.out.println("------------------------");
		//To get a specific pupil
		Query<Pupils> q2 = session.createQuery("from Pupils where id=5", Pupils.class);
		Pupils selectedPupil = q2.uniqueResult();
		System.out.println(selectedPupil);
		
		System.out.println("------------------------");
		//To get specific fields using select clause with where condition
		Query<Object[]> q3 = session.createQuery("select id, name from Pupils where id=:pupilId", Object[].class);
		q3.setParameter("pupilId", 6);
		Object[] sPupil = q3.uniqueResult();
		if (sPupil != null) {
		    System.out.println(sPupil[0] + " : " + sPupil[1]);
		} else {
		    System.out.println("No pupil found with the given id.");
		}
		
		System.out.println("------------------------");
		//To get specific fields using select clause without where condition
		Query<Object[]> q4 = session.createQuery("select id, name from Pupils",Object[].class);
		List<Object[]> sPupilList = q4.getResultList();
		for(Object[] o: sPupilList) {
			System.out.println(o[0] + " : " + o[1]);
		}
		
		System.out.println("------------------------");
		//To get sum of marks
		Query<Pupils> q5 = session.createQuery("select sum(marks) from Pupils", Pupils.class);
		Object totalMarks = q5.uniqueResult();
		System.out.println(totalMarks);
    	
    	session.getTransaction().commit();
    	session.close();

	}

}
