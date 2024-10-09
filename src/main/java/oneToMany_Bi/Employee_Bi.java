package oneToMany_Bi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee_Bi {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department_Bi department;
	
	public Employee_Bi() {}
	public Employee_Bi(String name, Department_Bi department) {
		this.name = name;
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department_Bi getDepartment() {
		return department;
	}
	public void setDepartment(Department_Bi department) {
		this.department = department;
	}
	
	
}
