package compragamerapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity 
@Table(name= "clients", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Client {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
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
	@Transient
    private List <Purchase> purchases;

	public Client(){
		
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
   
}
	