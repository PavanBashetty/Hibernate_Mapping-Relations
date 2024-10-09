package oneToOne_BiDirectional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users_bi")
public class User_Bi {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Address_Bi address;
	
	public User_Bi() {}
	public User_Bi(String name, Address_Bi address) {
		this.name = name;
		this.address = address;
		address.setUser(this);
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
	public Address_Bi getAddress() {
		return address;
	}
	public void setAddress(Address_Bi address) {
		this.address = address;
		address.setUser(this);
	}
	
}













