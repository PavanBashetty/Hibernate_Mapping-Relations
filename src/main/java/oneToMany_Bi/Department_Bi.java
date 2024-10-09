package oneToMany_Bi;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department_Bi {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String depName;
	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)
	private List<Employee_Bi> employees;
	
	public Department_Bi() {}
	public Department_Bi(String depName, List<Employee_Bi> employees) {
		this.depName = depName;
		this.employees = employees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public List<Employee_Bi> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee_Bi> employees) {
		this.employees = employees;
	}
	
	
}
