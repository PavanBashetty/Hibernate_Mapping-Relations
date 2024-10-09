package oneToOne_BiDirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Bi {

	public static void main(String[] args) {

		Address_Bi monAddress = new Address_Bi("NY","2nd street");
		User_Bi mon = new User_Bi("Monica",monAddress);
		User_Bi chan = new User_Bi("Chandler",monAddress);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(User_Bi.class).addAnnotatedClass(Address_Bi.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.persist(mon);
		session.persist(chan);
		
		session.getTransaction().commit();
		session.close();
		

	}

}
