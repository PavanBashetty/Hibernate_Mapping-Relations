package manyToMany_Bi;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="students_bi")
public class Student_Bi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_course_bi", // Join table name
        joinColumns = @JoinColumn(name = "student_id"), // Foreign key in join table for Student
        inverseJoinColumns = @JoinColumn(name = "course_id") // Foreign key in join table for Course
    )
	private List<Course_Bi> courses;
	
	public Student_Bi() {}
	public Student_Bi(String name, List<Course_Bi> courses) {
		this.name = name;
		this.courses = courses;
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
	public List<Course_Bi> getCourses() {
		return courses;
	}
	public void setCourses(List<Course_Bi> courses) {
		this.courses = courses;
	}
	
	
}
