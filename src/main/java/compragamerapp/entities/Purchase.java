package compragamerapp.entities;


import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAlias;

import org.hibernate.annotations.NotFound;

import ch.qos.logback.core.joran.spi.NoAutoStart;

@Entity
@Table(name= "purchases", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Purchase {
      
    
    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
	private long nro;
	
	@JsonAlias({"amount","totalAmount"})
    @Column(name = "amount")
    private float amount;
    
    @Column(name = "date")
    private Date date;
    
	@Column(name = "client_id")
    private long client_id;
	@Transient
    private List<Product> purchasedItems;
	

	public Purchase(){

	}
	
	public Purchase(float amount, Date date) {	
		this.amount = amount;
		this.date = date;
	}    

	public long getNro() {
		return nro;
	}
	public void setNro(long nro) {
		this.nro = nro;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public List<Product> getPurchasedItems() {
		return purchasedItems;
	}

	public void setPurchasedItems(List<Product> purchasedItems) {
		this.purchasedItems = purchasedItems;
	}
 
	public long getClient_id() {
		return client_id;
	}

	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}
	

}