package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		Address pavAddress = new Address("MidTown","5th Street");
		User pavan = new User("Goku", pavAddress);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Address.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.persist(pavan);
		
		session.getTransaction().commit();
		session.close();

	}

}
