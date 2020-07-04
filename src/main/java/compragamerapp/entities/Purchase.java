package compragamerapp.entities;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name= "purchase", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Purchase {
      
    
    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long nro;
  
    @Column(name = "amount")
    private float amount;
    
    @Column(name = "date")
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="client_id",nullable = false)
    private Cliente client;

    @OneToMany(mappedBy = "purchase",cascade = CascadeType.ALL)
    private ArrayList<Product> purchasedProducts = new ArrayList<>();
    
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

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}