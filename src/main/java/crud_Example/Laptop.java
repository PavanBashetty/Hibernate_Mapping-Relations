package crud_Example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="laptops")
public class Laptop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String laptopName;
	@ManyToOne
	@JoinColumn(name="pupil_id")
	private Pupil pupil;
	
	public Laptop() {}
	public Laptop(String laptopName, Pupil pupil) {
		this.laptopName = laptopName;
		this.pupil = pupil;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public Pupil getPupil() {
		return pupil;
	}
	public void setPupil(Pupil pupil) {
		this.pupil = pupil;
	}
	
	
}
