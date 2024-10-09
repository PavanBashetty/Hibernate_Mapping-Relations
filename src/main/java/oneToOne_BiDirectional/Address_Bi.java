package oneToOne_BiDirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="addresses_bi")
public class Address_Bi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String city;
    private String street;    
    @OneToOne
    @JoinColumn(name="user_id")
    private User_Bi user;

    public Address_Bi() {}
    public Address_Bi(String city, String street) {
    	this.city = city;
    	this.street = street;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public User_Bi getUser() {
		return user;
	}

	public void setUser(User_Bi user) {
		this.user = user;
	}
    
    
}
