package manyToMany;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="courses")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="student_course",
		joinColumns = @JoinColumn(name="course_id"),  // Foreign key in join table for Course
		inverseJoinColumns = @JoinColumn(name="student_id") // Foreign key in join table for Student
	)
	private List<Student> students;
	
	public Course() {}
	public Course(String title, List<Student> students) {
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
