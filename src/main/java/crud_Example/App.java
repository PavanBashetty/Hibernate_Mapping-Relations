package crud_Example;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {

	public static void main(String[] args) {
		
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Pupil.class);
		SessionFactory sf = config.buildSessionFactory();
		
		PupilDAO pupilDAO = new PupilDAO(sf);
		LaptopDAO laptopDAO = new LaptopDAO(sf);
		
    	Pupil shel = new Pupil("Sheldon");
    	Pupil leon = new Pupil("Leonard");
    	Pupil raj = new Pupil("Raj");
    	Pupil howy = new Pupil("Howard");
    	Pupil pen = new Pupil("Penny");
    	
        Laptop dell = new Laptop("Dell", shel);
        Laptop mac = new Laptop("MacBook",leon);
        Laptop dell2 = new Laptop("Inspiron",leon);
        Laptop mac2 = new Laptop("Air",raj);
        Laptop mac3 = new Laptop("mPro",howy);
        Laptop hp = new Laptop("Thinkpad",leon);
        Laptop leneovo = new Laptop("Ideapad",shel);
        
        shel.addLaptop(dell);
        shel.addLaptop(leneovo);
        leon.addLaptop(mac);
        leon.addLaptop(dell2);
        leon.addLaptop(hp);
        raj.addLaptop(mac2);
        howy.addLaptop(mac3);
        
        
        //SAVING
        pupilDAO.savePupil(shel);
        pupilDAO.savePupil(leon);
        pupilDAO.savePupil(raj);
        pupilDAO.savePupil(howy);
        pupilDAO.savePupil(pen);
        
        //READ
        Pupil pupil = pupilDAO.getPupilById(1);
        if(pupil != null) {
        	System.out.println("Pupil name: " + pupil.getPupilName());
        	List<Laptop> laptops = pupil.getLaptops();
        	System.out.println("Laptops owned by: " + pupil.getPupilName() + ":");
        	for(Laptop laptop:laptops) {
        		System.out.println(laptop.getLaptopName());
        	}
        }else {
        	System.out.println("Pupil not found!");
        }

	}

}
