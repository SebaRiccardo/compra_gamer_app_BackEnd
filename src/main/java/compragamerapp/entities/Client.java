package compragamerapp.entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity 
@Table(name= "client", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Client {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	@Column(name="name")
	private String name;

	@Column(name="last_name")
	private String lastName;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="address")
	private String address;

	@Column(name="email_address")
	private String email;

	@Column(name="purchases")
	@OneToMany(mappedBy="client",cascade= CascadeType.ALL)
    private ArrayList <Purchase> purchases = new ArrayList<>();

	public Client(String name, String lastName, String phone, String address, String email,ArrayList<Purchase> purchases) {
		
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phone;
		this.address = address;
		this.email = email;
		this.purchases = purchases;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phoneNumber;
	}
	public void setPhone(String phone) {
		this.phoneNumber = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
    }
    
	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}

}
	