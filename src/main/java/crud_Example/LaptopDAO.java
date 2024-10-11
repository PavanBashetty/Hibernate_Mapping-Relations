package crud_Example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LaptopDAO {

	private SessionFactory sf;
	
	public LaptopDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	//CREATE
	public void saveLaptop(Laptop laptop) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(laptop);
		session.getTransaction().commit();
		session.close();
	}
	
	//READ
	public Laptop getLaptopById(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		Laptop laptop = session.get(Laptop.class, id);
		session.getTransaction().commit();
		session.close();
		return laptop;
	}
	
	//UPDATE
	public void updateLaptop(Laptop laptop) {
		Session session = sf.openSession();
		session.beginTransaction();
		 // Merge handles both updates and insertions if needed
		session.merge(laptop);
		session.getTransaction().commit();
		session.close();
	}
	
	//DELETE
	public void deleteLaptop(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		Laptop laptop = session.get(Laptop.class, id);
		if(laptop != null) {
			session.remove(laptop);
		}
		session.getTransaction().commit();
		session.close();
	}
}

















