package crud_Example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pupils")
public class Pupil {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String pupilName;
	@OneToMany(mappedBy="pupil", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Laptop> laptops = new ArrayList<>();
	
	public Pupil() {}
	public Pupil(String pupilName) {
		this.pupilName = pupilName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPupilName() {
		return pupilName;
	}
	public void setPupilName(String pupilName) {
		this.pupilName = pupilName;
	}
	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	
	public void addLaptop(Laptop laptop) {
		this.laptops.add(laptop);
		laptop.setPupil(this);;
	}
	
	public void removeLaptop(Laptop laptop) {
		this.laptops.remove(laptop);
		laptop.setPupil(null);
	}
	
}
