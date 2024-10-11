package crud_Example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PupilDAO {

	private SessionFactory sf;
	
	public PupilDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	//CREATE
	public void savePupil(Pupil pupil) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(pupil);
		session.getTransaction().commit();
		session.close();
	}
	
	//READ
	public Pupil getPupilById(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		Pupil pupil = session.get(Pupil.class, id);
		session.getTransaction().commit();
		session.close();
		return pupil;
	}
	
	//UPDATE
	public void updatePupil(Pupil pupil) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.merge(pupil);
		session.getTransaction().commit();
		session.close();
	}
	
	//DELETE
	public void deletePupil(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		Pupil pupil = session.get(Pupil.class, id);
		if(pupil != null) {
			session.remove(pupil);
		}
		session.getTransaction().commit();
		session.close();
	}
}





