package manyToMany_Bi;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="courses_bi")
public class Course_Bi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@ManyToMany(mappedBy = "courses", cascade=CascadeType.ALL)
	private List<Student_Bi> students;
	
	public Course_Bi() {}
	public Course_Bi(String title, List<Student_Bi> students) {
        this.title = title;
        this.students = students;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Student_Bi> getStudents() {
		return students;
	}
	public void setStudents(List<Student_Bi> students) {
		this.students = students;
	}
	
	
}
